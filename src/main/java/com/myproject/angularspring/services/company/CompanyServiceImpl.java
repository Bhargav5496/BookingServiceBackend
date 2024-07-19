package com.myproject.angularspring.services.company;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.angularspring.dto.AdDto;
import com.myproject.angularspring.dto.ReservationDto;
import com.myproject.angularspring.entities.Ad;
import com.myproject.angularspring.entities.Reservation;
import com.myproject.angularspring.entities.User;
import com.myproject.angularspring.enums.ReservationStatus;
import com.myproject.angularspring.repository.AdRepository;
import com.myproject.angularspring.repository.ReservationRepository;
import com.myproject.angularspring.repository.UserRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public boolean postAd(Long userId, AdDto adDto) throws IOException{
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            Ad ad = new Ad();
            ad.setServiceName(adDto.getServiceName());
            ad.setPrice(adDto.getPrice());
            ad.setUser(optionalUser.get());
            ad.setImg(adDto.getImg().getBytes());
            ad.setDescription(adDto.getDescription());

            adRepository.save(ad);
            return true;
        }
        return false;
    }

    public List<AdDto> getAllAds(Long userId){
        return adRepository.findAllByUserId(userId).stream().map(Ad::getDto).collect(Collectors.toList());
    }

    public AdDto getAdById(Long id){
        Optional<Ad> optionalAd = adRepository.findById(id);
        if (optionalAd.isPresent()) {
            return optionalAd.get().getDto();
        }
        return null;
    }

    public boolean updateAd(Long adId, AdDto adDto) throws IOException{
        Optional<Ad> optionalAd = adRepository.findById(adId);
        if (optionalAd.isPresent()) {
            Ad ad = optionalAd.get();
            ad.setServiceName(adDto.getServiceName());
            ad.setPrice(adDto.getPrice());
            ad.setDescription(adDto.getDescription());
            if (adDto.getImg() != null) {
                ad.setImg(adDto.getImg().getBytes());
            }
            adRepository.save(ad);
            return true;
        }
        return false;
    }

    public boolean deleteAd(Long adId){
        Optional<Ad> optionalAd = adRepository.findById(adId);
        if (optionalAd.isPresent()) {
            Ad ad = optionalAd.get();
            adRepository.delete(ad);
            return true;
        }
        return false;
    }

    public List<ReservationDto> getAllAdBookings(Long companyId){
        return reservationRepository.findAllByCompanyId(companyId)
            .stream().map(Reservation::getDto).collect(Collectors.toList());
    }

    public boolean changeBookingStatus(Long bookingId, String status){
        Optional<Reservation> optionalReservation = reservationRepository.findById(bookingId);
        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();
            if (Objects.equals(status, "Approve")) {
                existingReservation.setReservationStatus(ReservationStatus.APPROVED);
            } else {
                existingReservation.setReservationStatus(ReservationStatus.REJECTED);
            }
            reservationRepository.save(existingReservation);
            return true;
        }
        return false;
    }
}
