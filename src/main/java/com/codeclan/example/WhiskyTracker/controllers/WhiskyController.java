package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public List<Whisky> getAllWhiskiesByYear(){ return whiskyRepository.findAll(); }

    @GetMapping(value = "/year/{year}")
    public List<Whisky> getAllWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.getAllWhiskiesByYear(year);
    }

//    @GetMapping
//    public List<Whisky> getAllWhiskiesFromDistilleryByAge(){ return whiskyRepository.findAll(); }

    @GetMapping(value = "/distillerybyyear/{distillery}/{age}")
    public List<Whisky> getAllWhiskiesFromDistilleryByAge(@PathVariable String distillery, int age){
        return whiskyRepository.getAllWhiskiesFromDistilleryByAge(distillery, age);
    }




}
