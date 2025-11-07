package com.sa.healntrack.report_service.transaction.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.transaction.application.port.in.create_transaction.CreateTransactionCommand;
import com.sa.healntrack.report_service.transaction.domain.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "area", source = "area")
    Transaction toDomain(CreateTransactionCommand command, Area area);

}
