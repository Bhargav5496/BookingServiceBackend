package com.myproject.angularspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.angularspring.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findAllByAdId(Long adId);
}
