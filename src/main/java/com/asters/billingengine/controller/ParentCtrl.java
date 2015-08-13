/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asters.billingengine.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asters.billingengine.model.Parent;
import com.asters.billingengine.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author premkrishna
 */
@RestController

public class ParentCtrl {

    @Autowired
    ParentRepo parentRepo;
    
    @RequestMapping(value="/api/parent", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Get All Parents", response = Parent.class)
    public Iterable<Parent> getAll() {
        System.out.println("GSM");
        return parentRepo.findAll();
    }
    
    @RequestMapping(value="/api/parent/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Get One Parents", response = Parent.class)
    public Iterable<Parent> getOne(@PathVariable long id) {
        System.out.println("GSM");
        return parentRepo.findById(id);
    }
    
    @RequestMapping(value="/api/parent", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "Get Parent", response = Parent.class)
    public Parent post(@RequestBody Parent parent) {
        return parentRepo.save(parent);
    }
}
