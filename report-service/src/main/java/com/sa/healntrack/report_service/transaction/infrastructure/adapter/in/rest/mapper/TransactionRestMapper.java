package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions.GetAllTransactionsQuery;
import com.sa.healntrack.report_service.transaction.domain.Transaction;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto.SearchTransactionsRequestDTO;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto.TransactionResponseDTO;

@Mapper(componentModel = "spring")
public interface TransactionRestMapper {
    
    GetAllTransactionsQuery toQuery(SearchTransactionsRequestDTO requestDTO);

    @Mapping(target = "id", source = "transaction.id.value")
    @Mapping(target = "amount", source = "transaction.amount.value")
    @Mapping(target = "area", source = "transaction.area.name.value")
    TransactionResponseDTO fromDomain(Transaction transaction);

}
