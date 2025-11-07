package com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging.message;

import java.util.UUID;

public record RoomUpdatedMessage(

        UUID id,
        String number

) { }
