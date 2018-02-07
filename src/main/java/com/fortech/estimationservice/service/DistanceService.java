package com.fortech.estimationservice.service;

import com.fortech.estimationservice.model.Distance;
import com.fortech.estimationservice.model.dto.EstimationDTO;
import com.fortech.estimationservice.repository.DistanceRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DistanceService {

    private DistanceRepository distanceRepository;

    public DistanceService(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    public EstimationDTO getEstimationDeliveryDate(String productId, Map<String, Integer> stock, int howMany) {

        Integer daysToArrive = 0;

        EstimationDTO estimationDTO = new EstimationDTO(productId, howMany, stock);

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {

            Distance distance = distanceRepository.findByCountry(entry.getKey());
            if (daysToArrive < distance.getDistance()) {
                daysToArrive = distance.getDistance();
            }
        }
        estimationDTO.setDaysToArrive(daysToArrive);
        return estimationDTO;
    }
}
