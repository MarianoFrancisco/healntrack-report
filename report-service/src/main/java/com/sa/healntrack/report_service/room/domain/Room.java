package com.sa.healntrack.report_service.room.domain;

import java.util.UUID;

import com.sa.healntrack.report_service.room.domain.value_object.RoomId;
import com.sa.healntrack.report_service.room.domain.value_object.RoomNumber;

import lombok.Getter;

@Getter
public class Room {

    private final RoomId id;
    private RoomNumber number;

    public Room(UUID id, String number) {
        this.id = new RoomId(id);
        this.number = new RoomNumber(number);
    }

    public void updateNumber(String number) {
        this.number = new RoomNumber(number);
    }
    
}
