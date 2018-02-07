package com.fortech.estimationservice.controller;

import com.fortech.estimationservice.model.Distance;
import com.fortech.estimationservice.model.dto.EstimationDTO;
import com.fortech.estimationservice.repository.DistanceRepository;
import com.fortech.estimationservice.service.DistanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EstimationController {

    private DistanceService distanceService;
    private DistanceRepository distanceRepository;

    public EstimationController(DistanceService distanceService, DistanceRepository distanceRepository) {
        this.distanceService = distanceService;
        this.distanceRepository = distanceRepository;
    }

    @GetMapping(value = "/delivery")
    public EstimationDTO getEstimationDelivery(@RequestParam(name = "id") String productId,
                                               @RequestParam(name = "howMany") int howMany,
                                               @RequestParam(name = "location") Map<String, Integer> location) {

        return distanceService.getEstimationDeliveryDate(productId, location, howMany);
    }

    @PostMapping("/add")
    public List<Distance> add(@RequestParam(name = "country") String country,
                              @RequestParam(name = "distance") Integer distance) {

        distanceRepository.save(new Distance(country, distance));
        return distanceRepository.findAll();
    }

    /**
     * Helper method
     *
     * @return all Distances
     */
    @GetMapping("distance/all")
    public List<Distance> getAll() {
        return distanceRepository.findAll();
    }
}
