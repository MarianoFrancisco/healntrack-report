package com.sa.healntrack.report_service.area.infrastructure.adapter.out.persistence.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Data
@Table(name = "dim_area")
@Entity
public class AreaEntity {
    
    @Id
    private UUID id;
    private String name;

}
