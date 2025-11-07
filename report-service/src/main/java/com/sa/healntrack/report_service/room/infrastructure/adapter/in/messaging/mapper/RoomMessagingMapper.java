package com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging.mapper;

import org.mapstruct.Mapper;

import com.sa.healntrack.report_service.room.application.port.in.create_room.CreateRoomCommand;
import com.sa.healntrack.report_service.room.application.port.in.update_room.UpdateRoomCommand;
import com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging.message.RoomCreatedMessage;
import com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging.message.RoomUpdatedMessage;

@Mapper(componentModel = "spring")
public interface RoomMessagingMapper {

    CreateRoomCommand toCommand(RoomCreatedMessage message);

    UpdateRoomCommand toCommand(RoomUpdatedMessage message);
    
}
