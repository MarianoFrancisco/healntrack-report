package com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.transaction.application.port.in.get_all_profits.GetAllProfitsQuery;
import com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions.GetAllTransactionsQuery;
import com.sa.healntrack.report_service.transaction.application.port.out.persistence.ExistsTransactionByReferenceId;
import com.sa.healntrack.report_service.transaction.application.port.out.persistence.FindAllProfits;
import com.sa.healntrack.report_service.transaction.application.port.out.persistence.FindAllTransactions;
import com.sa.healntrack.report_service.transaction.application.port.out.persistence.SaveTransaction;
import com.sa.healntrack.report_service.transaction.domain.Transaction;
import com.sa.healntrack.report_service.transaction.domain.TransactionProfit;
import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.entity.TransactionEntity;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.mapper.TransactionPersistenceMapper;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.repository.TransactionEntityRepository;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.specification.TransactionSpecs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class TransactionRepository implements SaveTransaction, FindAllTransactions, ExistsTransactionByReferenceId, FindAllProfits {

    private final TransactionPersistenceMapper mapper;
    private final TransactionEntityRepository repository;

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = repository
                .save(mapper.fromDomain(transaction));
        return mapper.toDomain(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Transaction> findAll(GetAllTransactionsQuery query) {
        Specification<TransactionEntity> specs = Specification.allOf(
                TransactionSpecs.hasArea(query.area()),
                TransactionSpecs.hasType(query.type()),
                TransactionSpecs.occurredBetween(query.startDate(), query.endDate()));
        return repository.findAll(specs).stream()
                .map(mapper::toDomain)
                .toList();
    }
    
    @Transactional(readOnly = true)
    @Override
    public boolean existsByReferenceId(UUID referenceId) {
        return repository.existsByReferenceId(referenceId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TransactionProfit> findAll(GetAllProfitsQuery query) {
        Specification<TransactionEntity> specs = Specification.allOf(
                TransactionSpecs.hasArea(query.area()),
                TransactionSpecs.occurredBetween(query.startDate(), query.endDate()));
        return repository.findAll(specs).stream()
                .map(t -> new TransactionProfit(
                        t.getReferenceId(),
                        new Area(t.getArea().getId(), t.getArea().getName(), t.getArea().getEntityReference()),
                        t.getType().equals(TransactionType.INCOME) ? t.getAmount() : t.getAmount().negate(),
                        t.getOccurredAt()
                ))
                .filter(t -> t.getAmount().compareTo(BigDecimal.ZERO) > 0)
                .toList();
    }

}
