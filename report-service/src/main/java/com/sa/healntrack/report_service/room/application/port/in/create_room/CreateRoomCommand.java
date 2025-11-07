package com.sa.healntrack.report_service.room.application.port.in.create_room;

import java.util.UUID;

public record CreateRoomCommand(

        UUID id,
        String number

) { }
