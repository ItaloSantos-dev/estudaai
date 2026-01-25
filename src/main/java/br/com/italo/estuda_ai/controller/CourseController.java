package br.com.italo.estuda_ai.controller;

import br.com.italo.estuda_ai.model.CourseModel;
import br.com.italo.estuda_ai.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;



    @GetMapping
    public List<CourseModel> getCourses(){
        return this.courseService.getAll();
    }
}
