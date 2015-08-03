/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asters.billingengine.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
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
    @ApiOperation(httpMethod = "GET", value = "Say Hello To World using Swagger")
    public String getChild() {
        System.out.println("GSM");
        return "A Child";
    }
}
