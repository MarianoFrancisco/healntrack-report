package com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.healntrack.report_service.common.infrastructure.exception.MessageSerializationException;
import com.sa.healntrack.report_service.employee.application.port.in.create_employee.CreateEmployee;
import com.sa.healntrack.report_service.employee.application.port.in.update_employee.UpdateEmployee;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging.mapper.EmployeeMessagingMapper;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging.message.EmployeeCreatedMessage;
import com.sa.healntrack.report_service.employee.infrastructure.adapter.in.messaging.message.EmployeeUpdatedMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EmployeeConsumer {
    
    private final ObjectMapper objectMapper;
    private final EmployeeMessagingMapper mapper;
    private final CreateEmployee createEmployee;
    private final UpdateEmployee updateEmployee;

    @KafkaListener(topics = "employee.created")
    public void listenEmployeeCreated(ConsumerRecord<String, byte[]> record) {
        try {
            EmployeeCreatedMessage message = objectMapper
                    .readValue(record.value(), EmployeeCreatedMessage.class);
            createEmployee.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "employee.updated")
    public void listenEmployeeUpdated(ConsumerRecord<String, byte[]> record) {
        try {
            EmployeeUpdatedMessage message = objectMapper
                    .readValue(record.value(), EmployeeUpdatedMessage.class);
            updateEmployee.update(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

}
