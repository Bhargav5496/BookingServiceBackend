package com.myproject.angularspring.services.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.angularspring.dto.AdDetailsForClientDto;
import com.myproject.angularspring.dto.AdDto;
import com.myproject.angularspring.dto.ReservationDto;
import com.myproject.angularspring.entities.Ad;
import com.myproject.angularspring.entities.Reservation;
import com.myproject.angularspring.entities.User;
import com.myproject.angularspring.enums.ReservationStatus;
import com.myproject.angularspring.enums.ReviewStatus;
import com.myproject.angularspring.repository.AdRepository;
import com.myproject.angularspring.repository.ReservationRepository;
import com.myproject.angularspring.repository.UserRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<AdDto> getAllAds(){
        return adRepository.findAll().stream().map(Ad::getDto).collect(Collectors.toList());
    }

    public List<AdDto> searchAdByName(String name){
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getDto).collect(Collectors.toList());
    }

    public boolean bookService(ReservationDto reservationDto){
        Optional<Ad> optionalAd = adRepository.findById(reservationDto.getAdId());
        Optional<User> optionalUser = userRepository.findById(reservationDto.getUserId());

        if (optionalAd.isPresent() && optionalUser.isPresent()) {
            Reservation reservation = new Reservation();

            reservation.setBookingDate(reservationDto.getBookingDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);
            reservation.setReviewStatus(ReviewStatus.FALSE);
            reservation.setUser(optionalUser.get());
            reservation.setAd(optionalAd.get());
            reservation.setCompany(optionalAd.get().getUser());

            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }

    public AdDetailsForClientDto getAdDetailsByAdId(Long adId){
        Optional<Ad> optionalAd = adRepository.findById(adId);
        AdDetailsForClientDto adDetailsForClientDto = new AdDetailsForClientDto();
        if (optionalAd.isPresent()) {
            adDetailsForClientDto.setAdDto(optionalAd.get().getDto());
        }
        return adDetailsForClientDto;
    }

    public List<ReservationDto> getAllAdBookings(Long userId){
        return reservationRepository.findAllByUserId(userId)
            .stream().map(Reservation::getDto).collect(Collectors.toList());
    }
    
}
