package com.myproject.angularspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.angularspring.dto.AdDto;
import com.myproject.angularspring.entities.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long>{

    List<Ad> findAllByUserId(Long userId);

    List<Ad> findAllByServiceNameContaining(String name);
    
}
