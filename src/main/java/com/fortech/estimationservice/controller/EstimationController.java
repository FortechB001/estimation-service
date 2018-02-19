package com.fortech.estimationservice.controller;

import com.fortech.estimationservice.model.Distance;
import com.fortech.estimationservice.model.dto.EstimationDTO;
import com.fortech.estimationservice.repository.DistanceRepository;
import com.fortech.estimationservice.service.DistanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/estimation")
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
                                               @RequestParam(name = "daysToArriveInDeposit") Integer daysToArriveInDeposit,
                                               @RequestParam(name = "country") String country) {

        Integer daysToCustomer = distanceService.getEstimationDeliveryDate(country) + daysToArriveInDeposit;
        return new EstimationDTO(productId, howMany, daysToArriveInDeposit, country, daysToCustomer);
    }

    @GetMapping(value = "/countries")
    public List<String> getCountryListWhereWeDeliver() {
        return distanceService.getAllCountries();
    }

    /**
     * Helper method to add data in DB
     *
     * @param country  name of country
     * @param distance distance from out location
     * @return all
     */
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
