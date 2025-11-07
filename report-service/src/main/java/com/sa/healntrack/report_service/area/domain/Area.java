package com.sa.healntrack.report_service.area.domain;

import java.util.UUID;

import com.sa.healntrack.report_service.area.domain.value_object.AreaId;
import com.sa.healntrack.report_service.area.domain.value_object.EntityReference;
import com.sa.healntrack.report_service.area.domain.value_object.Name;

import lombok.Getter;

@Getter
public class Area {

    private final AreaId id;
    private final Name name;
    private final EntityReference entityReference;
    
    public Area(UUID id, String name, EntityReference entityReference) {
        this.id = new AreaId(id);
        this.name = new Name(name);
        this.entityReference = entityReference;
    }

}
