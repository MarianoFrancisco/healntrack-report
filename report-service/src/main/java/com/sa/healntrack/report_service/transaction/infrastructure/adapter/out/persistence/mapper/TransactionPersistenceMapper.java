package com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.mapper.AreaPersistenceMapper;
import com.sa.healntrack.report_service.transaction.domain.Transaction;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.entity.TransactionEntity;

@Mapper(componentModel = "spring", uses = { AreaPersistenceMapper.class })
public interface TransactionPersistenceMapper {
    
    Transaction toDomain(TransactionEntity transactionEntity);

    @Mapping(target = "id", source = "transaction.id.value")
    @Mapping(target = "referenceId", source = "transaction.referenceId.value")
    @Mapping(target = "amount", source = "transaction.amount.value")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TransactionEntity fromDomain(Transaction transaction);

}
