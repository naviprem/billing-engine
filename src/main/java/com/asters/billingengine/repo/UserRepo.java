/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asters.billingengine.repo;

/**
 *
 * @author premkrishna
 */
import java.util.List;
import com.asters.billingengine.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {

	List<User> findByName(@Param("name") String name);
        List<User> findById(@Param("id") long id);

}
