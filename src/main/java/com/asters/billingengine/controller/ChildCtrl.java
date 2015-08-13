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

import com.asters.billingengine.model.Child;
import com.asters.billingengine.repo.ChildRepo;
import com.asters.billingengine.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author premkrishna
 */
@RestController
//@Api(value="ChildCtrl", description="child API", position=1)
//@RequestMapping(value = "")


public class ChildCtrl {

    @Autowired
    ChildRepo childRepo;
    
    @Autowired
    ParentRepo parentRepo;
    
    @RequestMapping(value="/api/child", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Get All Children", response = Child.class)
    public Iterable<Child> getAll() {
        System.out.println("GSM");
        return childRepo.findAll();
    }
    
    @RequestMapping(value="/api/child/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Get One Child", response = Child.class)
    public Iterable<Child> getOne(@PathVariable long id) {
        System.out.println("GSM");
        return childRepo.findById(id);
    }
    
    @RequestMapping(value="/api/child", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "Save Child", response = Child.class)
    public Child post(@RequestBody Child child) {
        System.out.println("GSM");
        return childRepo.save(child);
    }
}
