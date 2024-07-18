package com.myproject.angularspring.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AdDto {
    
    private Long id;
    private String serviceName;
    private String description;
    private Double price;
    private MultipartFile img;
    private byte[] returnedImg; 
    private String userId;
    private String companyName; 

    public AdDto(Long id, String serviceName, String description, Double price, String companyName, byte[] returnedImg) {
        this.id = id;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.companyName = companyName;
        this.returnedImg = returnedImg;
    }
}
