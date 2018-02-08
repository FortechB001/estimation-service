package com.fortech.estimationservice.model.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class EstimationDTO implements Serializable {

    @NonNull
    private String productId;
    @NonNull
    private Integer howMany;
    //when the product will arrive in our deposit - in days
    @NonNull
    private Integer daysToArriveInDeposit;
    @NonNull
    private String country;
    @NonNull
    private Integer daysToCustomer;
}
