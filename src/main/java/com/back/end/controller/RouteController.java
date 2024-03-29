package com.back.end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.entity.RouteEntity;
import com.back.end.service.RouteService;

@RestController
@RequestMapping("/routes")
public class RouteController {
    
    @Autowired
    private RouteService service;

    @PostMapping
    public ResponseEntity<?> addRoute(@RequestBody RouteEntity route, @RequestParam Long planeId){
        try {
            return ResponseEntity.ok(service.addRoute(route, planeId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problem route: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }
}
