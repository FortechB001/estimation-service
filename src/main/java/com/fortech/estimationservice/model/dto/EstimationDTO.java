package com.fortech.estimationservice.model.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class EstimationDTO implements Serializable {

    @NonNull
    private String productId;
    @NonNull
    private Integer howMany;

    private Integer daysToArrive;

    //<Country, how many are in stock>
    @NonNull
    private Map<String, Integer> stock;
}
