package br.com.italo.estuda_ai.controller;


import br.com.italo.estuda_ai.model.ModuleModel;
import br.com.italo.estuda_ai.repository.ModuleRepository;
import br.com.italo.estuda_ai.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public List<ModuleModel> getAllModules(){
        return this.moduleService.getAll();
    }
}
