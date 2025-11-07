package com.sa.healntrack.report_service.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.sa.healntrack.report_service.area.domain.Area;
import com.sa.healntrack.report_service.transaction.domain.value_object.ReferenceId;

import lombok.Getter;

@Getter
public class TransactionProfit {
    
    private final ReferenceId referenceId;
    private final Area area;
    private final BigDecimal amount;
    private final LocalDate occurredAt;
    private String concept;

    public TransactionProfit(UUID referenceId, Area area, BigDecimal amount, LocalDate occurredAt) {
        this.referenceId = new ReferenceId(referenceId);
        this.area = area;
        this.amount = amount;
        this.occurredAt = occurredAt;
    }

    public void defineConcept(String concept) {
        this.concept = concept;
    }

}
