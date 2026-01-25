package br.com.italo.estuda_ai.controller;

import br.com.italo.estuda_ai.model.QuestionModel;
import br.com.italo.estuda_ai.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    public List<QuestionModel> getAllLQuestions(){
        return this.questionService.getAll();
    }
}
