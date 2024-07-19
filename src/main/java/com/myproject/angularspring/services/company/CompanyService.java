package com.myproject.angularspring.services.company;

import java.io.IOException;
import java.util.List;

import com.myproject.angularspring.dto.AdDto;
import com.myproject.angularspring.dto.ReservationDto;

public interface CompanyService {
    boolean postAd(Long userId, AdDto adDto) throws IOException;
    List<AdDto> getAllAds(Long userId);
    AdDto getAdById(Long id);
    boolean updateAd(Long adId, AdDto adDto) throws IOException;
    boolean deleteAd(Long adId);
    List<ReservationDto> getAllAdBookings(Long companyId);
    boolean changeBookingStatus(Long bookingId, String status);
}