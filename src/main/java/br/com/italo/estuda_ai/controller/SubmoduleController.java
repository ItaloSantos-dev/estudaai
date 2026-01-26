package br.com.italo.estuda_ai.controller;

import br.com.italo.estuda_ai.DTOs.requests.RequestSubmodule;
import br.com.italo.estuda_ai.DTOs.responses.ResponseLinkSimplified;
import br.com.italo.estuda_ai.DTOs.responses.ResponseQuestionSimplified;
import br.com.italo.estuda_ai.DTOs.responses.ResponseSubmodule;
import br.com.italo.estuda_ai.DTOs.responses.relations.ResponseLinksOfSubmodule;
import br.com.italo.estuda_ai.DTOs.responses.relations.ResponseQuestionsOfSubmodule;
import br.com.italo.estuda_ai.model.LinkModel;
import br.com.italo.estuda_ai.model.QuestionModel;
import br.com.italo.estuda_ai.model.SubmoduleModel;
import br.com.italo.estuda_ai.service.SubmoduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/submodules")
public class SubmoduleController {
    @Autowired
    private SubmoduleService subModuleService;

    @GetMapping
    public ResponseEntity<List<ResponseSubmodule>> getAllSubmodules(){
        List<SubmoduleModel> submodules = this.subModuleService.getAllSubmodules();

        List<ResponseSubmodule> response = submodules.stream().map((submodule)->new ResponseSubmodule(submodule.getId(), submodule.getName(), submodule.getAverageDuration(), submodule.getModule().getName(), submodule.getModule().getCourse().getName())).toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSubmodule> getModule(@PathVariable String id){
        SubmoduleModel submodule = this.subModuleService.getSubmoduleById(id);

        ResponseSubmodule response = new ResponseSubmodule(
                submodule.getId(), submodule.getName(), submodule.getAverageDuration(), submodule.getModule().getName(), submodule.getModule().getCourse().getName()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseSubmodule> createSubmodule(@RequestBody RequestSubmodule requestCreateSubmodule){
        SubmoduleModel submodule = this.subModuleService.createSubmdule(requestCreateSubmodule);

        ResponseSubmodule response = new ResponseSubmodule(
                submodule.getId(), submodule.getName(), submodule.getAverageDuration(), submodule.getModule().getName(), submodule.getModule().getCourse().getName()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmodule(@PathVariable String id){
        this.subModuleService.deleteSubmodule(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSubmodule> updateSubmodule(
            @PathVariable String id, @RequestBody RequestSubmodule requestUpdateSubmodule
    ){
        SubmoduleModel submodule = this.subModuleService.updateSubmodule(id, requestUpdateSubmodule);

        ResponseSubmodule response = new ResponseSubmodule(
                submodule.getId(), submodule.getName(), submodule.getAverageDuration(), submodule.getModule().getName(), submodule.getModule().getCourse().getName()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/{id}/links")
    public ResponseEntity<ResponseLinksOfSubmodule> getLinksOfSubmodule(@PathVariable String id){
        List<LinkModel> links = new ArrayList<>(this.subModuleService.getLinksOfSubmodule(id));

        String submoduleName = links.getFirst().getSubmodule().getName();
        String moduleName = links.getFirst().getSubmodule().getModule().getName();
        String courseName = links.getFirst().getSubmodule().getModule().getCourse().getName();

        List<ResponseLinkSimplified> responseLinkSimplifieds = links.stream().map(link->new ResponseLinkSimplified(link.getId(), link.getTitle(), link.getLink())).toList();

        ResponseLinksOfSubmodule response = new ResponseLinksOfSubmodule(courseName, moduleName, submoduleName, responseLinkSimplifieds);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/{id}/questions")
    public ResponseEntity<ResponseQuestionsOfSubmodule> getQuestionsOfSubmodule(@PathVariable String id){
        List<QuestionModel> questions = new ArrayList<>(this.subModuleService.getQuestionsOfSubmodule(id));

        String submoduleName = questions.getFirst().getSubmodule().getName();
        String moduleName = questions.getFirst().getSubmodule().getModule().getName();
        String courseName = questions.getFirst().getSubmodule().getModule().getCourse().getName();

        List<ResponseQuestionSimplified > responseQuestionSimplifieds = questions.stream().map(question->new ResponseQuestionSimplified(question.getId(), question.getTitle(), question.getLink())).toList();

        ResponseQuestionsOfSubmodule response = new ResponseQuestionsOfSubmodule(courseName, moduleName, submoduleName, responseQuestionSimplifieds);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
