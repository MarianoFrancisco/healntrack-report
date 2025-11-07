package com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.healntrack.report_service.common.infrastructure.exception.MessageSerializationException;
import com.sa.healntrack.report_service.medicine.application.port.in.create_medicine.CreateMedicine;
import com.sa.healntrack.report_service.medicine.application.port.in.update_medicine.UpdateMedicine;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging.mapper.MedicineMessagingMapper;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging.message.MedicineCreatedMessage;
import com.sa.healntrack.report_service.medicine.infrastructure.adapter.in.messaging.message.MedicineUpdatedMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MedicineConsumer {
    
    private final ObjectMapper objectMapper;
    private final MedicineMessagingMapper mapper;
    private final CreateMedicine createMedicine;
    private final UpdateMedicine updateMedicine;

    @KafkaListener(topics = "pharmacy.medicine.created")
    public void listenMedicineCreated(ConsumerRecord<String, byte[]> record) {
        try {
            MedicineCreatedMessage message = objectMapper
                    .readValue(record.value(), MedicineCreatedMessage.class);
            createMedicine.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "pharmacy.medicine.updated")
    public void listenMedicineUpdated(ConsumerRecord<String, byte[]> record) {
        try {
            MedicineUpdatedMessage message = objectMapper
                    .readValue(record.value(), MedicineUpdatedMessage.class);
            updateMedicine.update(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

}
