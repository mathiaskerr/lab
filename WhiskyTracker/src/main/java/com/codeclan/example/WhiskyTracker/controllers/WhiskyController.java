package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>>findWhiskyByYearQueryString(@RequestParam(name="year")int name){
        return new ResponseEntity<>(whiskyRepository.findByYear(name),HttpStatus.OK);
    }

    @GetMapping(value = "/whisky1")
    public ResponseEntity<List<Whisky>>findWhiskyDistilleryAndAgeQueryString(@RequestParam (name= "name")String name, @RequestParam(value = "age") int value ){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(name, value),HttpStatus.OK);
    }



}
