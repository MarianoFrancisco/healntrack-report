package com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.healntrack.report_service.common.infrastructure.exception.MessageSerializationException;
import com.sa.healntrack.report_service.room.application.port.in.create_room.CreateRoom;
import com.sa.healntrack.report_service.room.application.port.in.update_room.UpdateRoom;
import com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging.mapper.RoomMessagingMapper;
import com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging.message.RoomCreatedMessage;
import com.sa.healntrack.report_service.room.infrastructure.adapter.in.messaging.message.RoomUpdatedMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RoomConsumer {
    
    private final ObjectMapper objectMapper;
    private final RoomMessagingMapper mapper;
    private final CreateRoom createRoom;
    private final UpdateRoom updateRoom;

    @KafkaListener(topics = "hospitalization.room.created")
    public void listenRoomCreated(ConsumerRecord<String, byte[]> record) {
        try {
            RoomCreatedMessage message = objectMapper
                    .readValue(record.value(), RoomCreatedMessage.class);
            createRoom.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "hospitalization.room.updated")
    public void listenRoomUpdated(ConsumerRecord<String, byte[]> record) {
        try {
            RoomUpdatedMessage message = objectMapper
                    .readValue(record.value(), RoomUpdatedMessage.class);
            updateRoom.update(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

}
