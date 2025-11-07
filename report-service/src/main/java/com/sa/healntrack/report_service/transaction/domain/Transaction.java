package com.sa.healntrack.report_service.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.transaction.domain.value_object.Money;
import com.sa.healntrack.report_service.transaction.domain.value_object.ReferenceId;
import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionId;
import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;

import lombok.Getter;

@Getter
public class Transaction {

    private final TransactionId id;
    private final Area area;
    private final ReferenceId referenceId;
    private final Money amount;
    private final LocalDate occurredAt;
    private final TransactionType type;
    private String concept;

    public Transaction(UUID id, Area area, UUID referenceId,
            BigDecimal amount, LocalDate occurredAt, TransactionType type) {
        this.id = new TransactionId(id);
        this.area = area;
        this.referenceId = new ReferenceId(referenceId);
        this.amount = new Money(amount);
        this.occurredAt = occurredAt;
        this.type = type;
    }

    public void defineConcept(String concept) {
        this.concept = concept;
    }
    
}
