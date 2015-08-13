/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asters.billingengine.service;

import com.asters.billingengine.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.asters.billingengine.model.User;
import java.util.List;

/**
 *
 * @author premkrishna
 */

@Component
public class AuthService {
    
    @Autowired
    UserRepo userRepo;
    
    public boolean authenticate(User user) {
        boolean returnValue = false;
        
        List<User> usersInDB = userRepo.findByName(user.getName());
        if (usersInDB.size() > 0) {
            returnValue = usersInDB.get(0).getPassword().equalsIgnoreCase(user.getPassword());
        }
        return returnValue;
    }
}
