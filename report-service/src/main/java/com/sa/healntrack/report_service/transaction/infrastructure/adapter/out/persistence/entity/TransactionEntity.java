package com.sa.healntrack.report_service.transaction.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.entity.AreaEntity;
import com.sa.healntrack.report_service.transaction.domain.value_object.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Data
@Table(name = "fact_transaction")
@Entity
public class TransactionEntity {
    
    @Id
    private UUID id;
    private UUID referenceId;
    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaEntity area;
    private BigDecimal amount;
    private LocalDate occurredAt;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
