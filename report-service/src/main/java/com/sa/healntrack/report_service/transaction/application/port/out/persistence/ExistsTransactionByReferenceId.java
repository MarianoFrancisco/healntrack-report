package com.sa.healntrack.report_service.transaction.application.port.out.persistence;

import java.util.UUID;

public interface ExistsTransactionByReferenceId {
    
    boolean existsByReferenceId(UUID referenceId);

}
