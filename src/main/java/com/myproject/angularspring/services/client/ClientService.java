package com.myproject.angularspring.services.client;

import java.util.List;

import com.myproject.angularspring.dto.AdDto;

public interface ClientService{
    List<AdDto> getAllAds();
    List<AdDto> searchAdByName(String name);
}
