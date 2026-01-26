package br.com.italo.estuda_ai.controller;

import br.com.italo.estuda_ai.DTOs.requests.RequestCourse;
import br.com.italo.estuda_ai.DTOs.responses.ResponseModuleSimplified;
import br.com.italo.estuda_ai.DTOs.responses.relations.ResponseModulesOfCourse;
import br.com.italo.estuda_ai.model.CourseModel;
import br.com.italo.estuda_ai.model.ModuleModel;
import br.com.italo.estuda_ai.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;



    @GetMapping
    public ResponseEntity<List<CourseModel>> getCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(this.courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModel> getCourse(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(this.courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody RequestCourse requestCreateCourse){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.courseService.createCourse(requestCreateCourse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        this.courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseModel> updateCourse(
            @PathVariable String id, @RequestBody RequestCourse requestUpdateCourse
    ){
        return ResponseEntity.status(HttpStatus.OK).body(this.courseService.updateCourse(id, requestUpdateCourse));
    }

    //Rotas de relações
    @GetMapping("/{id}/modules")
    public ResponseEntity<ResponseModulesOfCourse> getModulesOfCourse(@PathVariable String id){

        ArrayList<ModuleModel> modules = new ArrayList<>(this.courseService.getModulesOfCourse(id));

        String courseName = modules.getFirst().getName();

        List<ResponseModuleSimplified> moduleWithOutCourseNames = modules.stream().map
                (module-> new ResponseModuleSimplified(module.getId(), module.getName(), module.getAverageDuration()))
                .toList();

        ResponseModulesOfCourse response = new ResponseModulesOfCourse(courseName, moduleWithOutCourseNames);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }







}
