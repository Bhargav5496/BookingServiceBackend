package com.myproject.angularspring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private Date reviewDate;
    private String review;
    private Long rating;
    private Long userId;
    private Long adId;
    private String clientName;
    private String serviceName;
    private Long bookingId;

    public ReviewDto(Long id, Date reviewDate, String review, Long rating, Long userId, Long adId, String clientName, String serviceName) {
        this.id = id;
        this.reviewDate = reviewDate;
        this.review = review;
        this.rating = rating;
        this.userId = userId;
        this.adId = adId;
        this.clientName = clientName;
        this.serviceName = serviceName;
    }
}