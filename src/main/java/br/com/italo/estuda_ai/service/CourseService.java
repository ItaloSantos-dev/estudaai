package br.com.italo.estuda_ai.service;


import br.com.italo.estuda_ai.DTOs.requests.RequestCourse;
import br.com.italo.estuda_ai.DTOs.responses.ResponseModule;
import br.com.italo.estuda_ai.DTOs.responses.relations.ResponseModulesOfCourse;
import br.com.italo.estuda_ai.model.CourseModel;
import br.com.italo.estuda_ai.model.ModuleModel;
import br.com.italo.estuda_ai.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.*;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<CourseModel> getAllCourses(){
        return this.courseRepository.findAll();
    }

    public CourseModel getCourseById(String id){
        return  this.courseRepository.findById(UUID.fromString(id)).get();
    }


    public CourseModel createCourse(RequestCourse request){
        CourseModel newCourse = new CourseModel();

        newCourse.setName(request.name());
        newCourse.setDescription(request.description());
        newCourse.setAverageDuration(Duration.ofHours(request.averageDuration()));

        this.courseRepository.save(newCourse);
        return newCourse;
    }

    public void deleteCourse(String  id){
        UUID courseId = UUID.fromString(id);
        this.courseRepository.deleteById(courseId);
    }

    public CourseModel updateCourse(String id, RequestCourse request){


        CourseModel course = this.courseRepository.findById(UUID.fromString(id)).get();

        course.setName(request.name());
        course.setDescription(request.description());
        course.setAverageDuration(Duration.ofHours(request.averageDuration()));


        return this.courseRepository.save(course);
    }


    public Set<ModuleModel> getModulesOfCourse(String courseId){
        Set<ModuleModel> modules = this.courseRepository.findById(UUID.fromString(courseId)).get().getModules();
        return modules;
    }

}
