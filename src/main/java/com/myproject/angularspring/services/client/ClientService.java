package com.myproject.angularspring.services.client;

import java.util.List;

import com.myproject.angularspring.dto.AdDetailsForClientDto;
import com.myproject.angularspring.dto.AdDto;
import com.myproject.angularspring.dto.ReservationDto;
import com.myproject.angularspring.dto.ReviewDto;

public interface ClientService{
    List<AdDto> getAllAds();
    List<AdDto> searchAdByName(String name);
    boolean bookService(ReservationDto reservationDto);
    AdDetailsForClientDto getAdDetailsByAdId(Long adId);
    List<ReservationDto> getAllAdBookings(Long userId);
    Boolean giveReview(ReviewDto reviewDto);
}
