package br.com.italo.estuda_ai.controller;

import br.com.italo.estuda_ai.model.SubmoduleModel;
import br.com.italo.estuda_ai.service.SubmoduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submodules")
public class SubmoduleController {
    @Autowired
    private SubmoduleService subModuleService;

    @GetMapping
    public List<SubmoduleModel> getAllSubmodules(){
        return this.subModuleService.getAll();
    }
}
