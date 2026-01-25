package br.com.italo.estuda_ai.controller;

import br.com.italo.estuda_ai.model.UserModel;
import br.com.italo.estuda_ai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAllUsers(){
        return this.userService.getAll();
    }
}
