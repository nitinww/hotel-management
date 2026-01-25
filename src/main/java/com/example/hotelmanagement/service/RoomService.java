package com.example.hotelmanagement.service;

import com.example.hotelmanagement.entity.Room;
import com.example.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;


    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailableTrue();
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found") );
    }

    public void deleteRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found") );
        roomRepository.delete(room);
    }

    public Room updateRoom(Long roomId, Room room) {
        Room oldRoom = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found") );
        oldRoom.setRoomNumber(room.getRoomNumber() == null ? oldRoom.getRoomNumber() : room.getRoomNumber());
        oldRoom.setType(room.getType() == null ? oldRoom.getType() : room.getType());
        oldRoom.setPrice(room.getPrice() == 0.0 ? oldRoom.getPrice() : room.getPrice());

        return roomRepository.save(oldRoom);
    }
}
