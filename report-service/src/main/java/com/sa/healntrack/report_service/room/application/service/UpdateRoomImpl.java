package com.sa.healntrack.report_service.room.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.common.application.exception.EntityAlreadyExistsException;
import com.sa.healntrack.report_service.common.application.exception.EntityNotFoundException;
import com.sa.healntrack.report_service.room.application.port.in.update_room.UpdateRoom;
import com.sa.healntrack.report_service.room.application.port.in.update_room.UpdateRoomCommand;
import com.sa.healntrack.report_service.room.application.port.out.persistence.ExistsRoomByNumberAndIdNot;
import com.sa.healntrack.report_service.room.application.port.out.persistence.FindRoomById;
import com.sa.healntrack.report_service.room.application.port.out.persistence.SaveRoom;
import com.sa.healntrack.report_service.room.domain.Room;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdateRoomImpl implements UpdateRoom {
    
    private final FindRoomById findRoomById;
    private final ExistsRoomByNumberAndIdNot existsRoomByNumberAndIdNot;
    private final SaveRoom saveRoom;

    @Override
    public void update(UpdateRoomCommand command) {
        Room room = findRoomById.findById(command.id())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No existe una habitacion con el id: " + command.id()));
        boolean existsRoom = existsRoomByNumberAndIdNot
                .existsByNumberAndIdNot(command.number(), command.id());
        if (existsRoom) {
            throw new EntityAlreadyExistsException(
                    "Ya existe una habitacion con el numero: " + command.number());
        }
        room.updateNumber(command.number());
        saveRoom.save(room);
    }

}