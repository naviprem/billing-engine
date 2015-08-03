/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asters.billingengine.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author premkrishna
 */
@RestController
//@Api(value="ChildCtrl", description="child API", position=1)
//@RequestMapping(value = "")


public class ChildCtrl {

    
    @RequestMapping(value="/api/child", method = RequestMethod.GET)
    @ApiOperation(
            httpMethod = "GET", 
            value = "Get Child",
            notes = "API to get child details",
            response = String.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found") })

    public String getChild() {
        System.out.println("GSM");
        return "A Child";
    }
}
