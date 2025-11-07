package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.healntrack.report_service.common.infrastructure.exception.MessageSerializationException;
import com.sa.healntrack.report_service.transaction.application.port.in.create_transaction.CreateTransaction;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.mapper.TransactionMessagingMapper;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.AccountPayableClosedMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.ConsultationRegisteredMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.EmployeePaymentRegisteredMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.MedicineSoldMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.RoomPaymentRegisteredMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TransactionConsumer {
    
    private final ObjectMapper objectMapper;
    private final TransactionMessagingMapper mapper;
    private final CreateTransaction createTransaction;

    @KafkaListener(topics = "accountpayable.closed")
    public void listenAccountPayableClosed(ConsumerRecord<String, byte[]> record) {
        try {
            AccountPayableClosedMessage message = objectMapper
                    .readValue(record.value(), AccountPayableClosedMessage.class);
            String service = message.service();
            if (!service.equals("MED")) {
                createTransaction.create(mapper.toCommand(
                        message,
                        service.equals("STAY") ? "STAY" : "SURGERY"));
            }
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "consultation.registered")
    public void listenConsultationRegistered(ConsumerRecord<String, byte[]> record) {
        try {
            ConsultationRegisteredMessage message = objectMapper
                    .readValue(record.value(), ConsultationRegisteredMessage.class);
            createTransaction.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "employee.payment.registered")
    public void listenEmployeePaymentRegistered(ConsumerRecord<String, byte[]> record) {
        try {
            EmployeePaymentRegisteredMessage message = objectMapper
                    .readValue(record.value(), EmployeePaymentRegisteredMessage.class);
            createTransaction.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "pharmacy.medicine.sold")
    public void listenMedicineSold(ConsumerRecord<String, byte[]> record) {
        try {
            MedicineSoldMessage message = objectMapper
                    .readValue(record.value(), MedicineSoldMessage.class);
            createTransaction.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

    @KafkaListener(topics = "hospitalization.roompayment.registered")
    public void listenRoomPaymentRegistered(ConsumerRecord<String, byte[]> record) {
        try {
            RoomPaymentRegisteredMessage message = objectMapper
                    .readValue(record.value(), RoomPaymentRegisteredMessage.class);
            createTransaction.create(mapper.toCommand(message));
        } catch (IOException e) {
            throw new MessageSerializationException("No se pudo deserializar el mensaje");
        }
    }

}
