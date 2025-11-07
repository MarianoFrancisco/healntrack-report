package com.sa.healntrack.report_service.room.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityAlreadyExistsException;
import com.sa.healntrack.report_service.room.application.mapper.RoomMapper;
import com.sa.healntrack.report_service.room.application.port.in.create_room.CreateRoom;
import com.sa.healntrack.report_service.room.application.port.in.create_room.CreateRoomCommand;
import com.sa.healntrack.report_service.room.application.port.out.persistence.ExistsRoomById;
import com.sa.healntrack.report_service.room.application.port.out.persistence.ExistsRoomByNumber;
import com.sa.healntrack.report_service.room.application.port.out.persistence.SaveRoom;
import com.sa.healntrack.report_service.room.domain.Room;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateRoomImpl implements CreateRoom {
    
    private final RoomMapper mapper;
    private final ExistsRoomById existsRoomById;
    private final ExistsRoomByNumber existsRoomByNumber;
    private final SaveRoom saveRoom;

    @Override
    public void create(CreateRoomCommand command) {
        if (existsRoomById.existsById(command.id())) {
            throw new EntityAlreadyExistsException(
                    "Ya existe una habitacion con id: " + command.id());
        }
        if (existsRoomByNumber.existsByNumber(command.number())) {
            throw new EntityAlreadyExistsException(
                    "Ya existe una habitacion con numero: " + command.number());
        }
        Room room = mapper.toDomain(command);
        saveRoom.save(room);
    }

}
