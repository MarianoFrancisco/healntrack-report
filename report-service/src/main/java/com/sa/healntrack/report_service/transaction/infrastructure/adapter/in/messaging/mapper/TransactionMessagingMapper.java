package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.transaction.application.port.in.create_transaction.CreateTransactionCommand;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.AccountPayableClosedMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.ConsultationRegisteredMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.EmployeePaymentRegisteredMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.MedicineSoldMessage;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.messaging.message.RoomPaymentRegisteredMessage;

@Mapper(componentModel = "spring")
public interface TransactionMessagingMapper {

    @Mapping(target = "referenceId", source = "message.patientId")
    @Mapping(target = "amount", source = "message.fee")
    @Mapping(target = "occurredAt", source = "message.serviceDate")
    @Mapping(target = "type", constant = "INCOME")
    CreateTransactionCommand toCommand(AccountPayableClosedMessage message, String area);

    @Mapping(target = "area", constant = "CONSULTATION")
    @Mapping(target = "referenceId", source = "message.patientId")
    @Mapping(target = "amount", source = "message.totalFee")
    @Mapping(target = "occurredAt", source = "message.date")
    @Mapping(target = "type", constant = "INCOME")
    CreateTransactionCommand toCommand(ConsultationRegisteredMessage message);

    @Mapping(target = "area", source = "message.service")
    @Mapping(target = "referenceId", source = "message.medicineId")
    @Mapping(target = "amount", source = "message.lineTotal")
    CreateTransactionCommand toCommand(MedicineSoldMessage message);

    @Mapping(target = "area", constant = "ROOM")
    @Mapping(target = "referenceId", source = "message.roomId")
    @Mapping(target = "amount", source = "message.totalAmount")
    @Mapping(target = "occurredAt", source = "message.paymentDate")
    @Mapping(target = "type", constant = "EXPENSE")
    CreateTransactionCommand toCommand(RoomPaymentRegisteredMessage message);

    @Mapping(target = "area", constant = "EMPLOYEE")
    @Mapping(target = "referenceId", source = "message.employeeId")
    @Mapping(target = "amount", source = "message.totalNetAmount")
    @Mapping(target = "occurredAt", source = "message.payDay")
    @Mapping(target = "type", constant = "EXPENSE")
    CreateTransactionCommand toCommand(EmployeePaymentRegisteredMessage message);
    
}
