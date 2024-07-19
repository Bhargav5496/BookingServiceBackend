package com.myproject.angularspring.entities;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.myproject.angularspring.dto.ReservationDto;
import com.myproject.angularspring.enums.ReservationStatus;
import com.myproject.angularspring.enums.ReviewStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Date bookingDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User company;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ad_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ad ad;


    public ReservationDto getDto(){
        return new ReservationDto(id, bookingDate, ad.getServiceName(), reservationStatus, reviewStatus, user.getId(), user.getName(), company.getId(), ad.getId());
    }

}
