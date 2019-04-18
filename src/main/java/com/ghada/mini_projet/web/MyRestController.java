package com.ghada.mini_projet.web;

import com.ghada.mini_projet.Client;
import com.ghada.mini_projet.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/listclient",method = RequestMethod.GET)
    public List<Client> list(){
        return clientRepository.findAll();
    }

}
