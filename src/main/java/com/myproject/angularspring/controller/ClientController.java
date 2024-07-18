package com.myproject.angularspring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.myproject.angularspring.services.client.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/client")
public class ClientController {
 
    @Autowired
    private ClientService clientService;

    @GetMapping("/ads")
    public ResponseEntity<?> getAllAds(){
        return ResponseEntity.ok(clientService.getAllAds());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchAllAdsByServiceName(@PathVariable String name){
        return ResponseEntity.ok(clientService.searchAdByName(name));
    }
}
 