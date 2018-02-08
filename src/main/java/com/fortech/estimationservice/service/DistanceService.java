package com.fortech.estimationservice.service;

import com.fortech.estimationservice.model.Distance;
import com.fortech.estimationservice.repository.DistanceRepository;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private DistanceRepository distanceRepository;

    public DistanceService(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    public Integer getEstimationDeliveryDate(String country) {

        Distance distance = distanceRepository.findByCountryIgnoreCase(country);
        return distance.getDistance();
    }
}
