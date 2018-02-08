package com.fortech.estimationservice.repository;

import com.fortech.estimationservice.model.Distance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceRepository extends MongoRepository<Distance, String>{

    Distance findByCountryIgnoreCase(String country);
}
