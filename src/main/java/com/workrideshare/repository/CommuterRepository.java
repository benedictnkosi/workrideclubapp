package com.workrideshare.repository;

import com.workrideshare.model.Address;
import com.workrideshare.model.Commuter;
import org.apache.catalina.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface CommuterRepository extends CrudRepository<Commuter, Integer> {
    Commuter findByEmail(String email);
    List<Commuter> findAllByEmail(String email);
}
