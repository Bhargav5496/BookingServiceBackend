package com.myproject.angularspring.services.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.angularspring.dto.AdDto;
import com.myproject.angularspring.entities.Ad;
import com.myproject.angularspring.repository.AdRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private AdRepository adRepository;
    
    public List<AdDto> getAllAds(){
        return adRepository.findAll().stream().map(Ad::getDto).collect(Collectors.toList());
    }

    public List<AdDto> searchAdByName(String name){
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getDto).collect(Collectors.toList());
    }
    
}
