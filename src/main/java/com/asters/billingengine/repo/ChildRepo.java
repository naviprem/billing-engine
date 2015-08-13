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
import com.asters.billingengine.model.Child;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ChildRepo extends PagingAndSortingRepository<Child, Long> {

	List<Child> findByName(@Param("name") String name);
        List<Child> findById(@Param("id") long id);

}
