package com.myproject.angularspring.dto;

import java.util.List;

import lombok.Data;

@Data
public class AdDetailsForClientDto {
    private AdDto adDto;
    private List<ReviewDto> reviewDtoList;
}