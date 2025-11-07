package com.sa.healntrack.report_service.room.application.port.in.update_room;

import java.util.UUID;

public record UpdateRoomCommand(

        UUID id,
        String number

) { }
