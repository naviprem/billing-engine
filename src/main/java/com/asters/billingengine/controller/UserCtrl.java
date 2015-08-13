/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asters.billingengine.controller;

import com.asters.billingengine.service.AuthService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asters.billingengine.model.User;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author premkrishna
 */
@RestController

public class UserCtrl {

    @Autowired
    AuthService authService;
    

    @RequestMapping(value="/api/user/authenticate", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "Authenticate User", response = Void.class)
    public void authenticate(@RequestBody User user, HttpServletResponse response) {
        System.out.println("GSM");
        if (authService.authenticate(user)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

}
