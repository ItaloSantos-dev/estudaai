package br.com.italo.estuda_ai.controller;


import br.com.italo.estuda_ai.model.LinkModel;
import br.com.italo.estuda_ai.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    private LinkService linkService;

    public List<LinkModel> getAllLinks(){
        return this.linkService.getAll();
    }
}
