package com.example.hotelmanagement.service;

import com.example.hotelmanagement.entity.Booking;
import com.example.hotelmanagement.entity.Room;
import com.example.hotelmanagement.exception.RoomNotAvailableException;
import com.example.hotelmanagement.repository.BookingRepository;
import com.example.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    @Autowired
    private RoomRepository roomRepository;

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking addBooking(Long roomId, Booking booking) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotAvailableException("Room not found"));


        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room not available");
        }

        room.setAvailable(false);
        booking.setRoom(room);
        roomRepository.save(room);
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RoomNotAvailableException("Booking not found"));

        Room room = booking.getRoom();

        room.setAvailable(true);
        roomRepository.save(room);

        bookingRepository.deleteById(bookingId);
    }

    public Booking updateBooking(Long bookingId, Booking booking) {
        Booking oldBooking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found") );
        oldBooking.setCustomerName(booking.getCustomerName() == null ? oldBooking.getCustomerName() : booking.getCustomerName());
        oldBooking.setCustomerEmail(booking.getCustomerEmail() == null ? oldBooking.getCustomerEmail() : booking.getCustomerEmail());
        oldBooking.setCheckInDate(booking.getCheckInDate() == null ? oldBooking.getCheckInDate() : booking.getCheckInDate());
        oldBooking.setCheckOutDate(booking.getCheckOutDate() ==  null ? oldBooking.getCheckOutDate() : booking.getCheckOutDate());

        return bookingRepository.save(oldBooking);
    }
}
