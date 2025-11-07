package com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.healntrack.report_service.common.infrastructure.exception.MessageSerializationException;
import com.sa.healntrack.report_service.patient.application.port.in.create_patient.CreatePatient;
import com.sa.healntrack.report_service.patient.application.port.in.update_patient.UpdatePatient;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.mapper.PatientMessagingMapper;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.message.PatientCreatedMessage;
import com.sa.healntrack.report_service.patient.infrastructure.adapter.in.messaging.message.PatientUpdatedMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PatientConsumer {

    private final ObjectMapper objectMapper;
    private final PatientMessagingMapper mapper;
    private final CreatePatient createPatient;
    private final UpdatePatient updatePatient;

    @KafkaListener(topics = "patient.created")
    public void listenPatientCreated(ConsumerRecord<String, byte[]> record) {
        try {
            PatientCreatedMessage message = objectMapper
                    .readValue(record.value(), PatientCreatedMessage.class);
            createPatient.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "patient.updated")
    public void listenPatientUpdated(ConsumerRecord<String, byte[]> record) {
        try {
            PatientUpdatedMessage message = objectMapper
                    .readValue(record.value(), PatientUpdatedMessage.class);
            updatePatient.update(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }
    
}
