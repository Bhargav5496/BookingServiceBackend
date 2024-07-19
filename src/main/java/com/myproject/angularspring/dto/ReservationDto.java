package com.myproject.angularspring.dto;

import java.util.Date;

import com.myproject.angularspring.enums.ReservationStatus;
import com.myproject.angularspring.enums.ReviewStatus;

import lombok.Data;

@Data
public class ReservationDto {
    private Long id;
    private Date bookingDate;
    private String serviceName;
    private ReservationStatus reservationStatus; 
    private ReviewStatus reviewStatus;
    private Long userId;
    private String userName;
    private Long companyId;
    private Long adId;

    public ReservationDto(Long id, Date bookingDate, String serviceName, ReservationStatus reservationStatus, ReviewStatus reviewStatus, Long userId, String userName, Long companyId, Long adId) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.serviceName = serviceName;
        this.reservationStatus = reservationStatus;
        this.reviewStatus = reviewStatus;
        this.userId = userId;
        this.userName = userName;
        this.companyId = companyId;
        this.adId = adId;
    }
}
