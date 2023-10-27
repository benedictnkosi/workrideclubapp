package com.workrideshare.repository;

import com.workrideshare.model.MatchedCommuters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<MatchedCommuters, Integer> {

}