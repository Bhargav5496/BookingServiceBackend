package com.myproject.angularspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.angularspring.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByCompanyId(Long companyId);
    List<Reservation> findAllByUserId(Long userId);
}
