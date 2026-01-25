package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.entity.Booking;
import com.example.hotelmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public List<Booking> findBookings() {
        return bookingService.findAllBookings();
    }

    @PostMapping("/room/{roomId}")
    public Booking bookRoom(@PathVariable Long roomId, @RequestBody Booking booking) {
        return bookingService.addBooking(roomId, booking);
    }

    @DeleteMapping("booking/{bookingId}")
    public String deleteRoom(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return "Booking deleted successfully";
    }

    @PutMapping("booking/{bookingId}")
    public Booking updateBooking(@PathVariable Long bookingId, @RequestBody Booking booking) {
        return bookingService.updateBooking(bookingId, booking);
    }
}
