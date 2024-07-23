package com.myproject.angularspring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.myproject.angularspring.dto.ReservationDto;
import com.myproject.angularspring.dto.ReviewDto;
import com.myproject.angularspring.services.client.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/client")
public class ClientController {
 
    @Autowired
    private ClientService clientService;

    @GetMapping("/ads")
    public ResponseEntity<?> getAllAds(){
        return ResponseEntity.ok(clientService.getAllAds());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchAllAdsByServiceName(@PathVariable String name){
        return ResponseEntity.ok(clientService.searchAdByName(name));
    }

    @PostMapping("/book-service")
    public ResponseEntity<?> bookService(@RequestBody ReservationDto reservationDto) {
        boolean success = clientService.bookService(reservationDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } 
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/ad/{adId}")
    public ResponseEntity<?> getAdDetailsByAdId(@PathVariable Long adId) {
        return ResponseEntity.ok(clientService.getAdDetailsByAdId(adId));
    }

    @GetMapping("/my-bookings/{userId}")
    public ResponseEntity<List<ReservationDto>> getAllBookingsByCompany(@PathVariable Long userId) {
        return ResponseEntity.ok(clientService.getAllAdBookings(userId));
    }

    @PostMapping("/review")
    public ResponseEntity<?> postReview(@RequestBody ReviewDto reviewDto) {
        Boolean success = clientService.giveReview(reviewDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
} 