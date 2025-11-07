package com.sa.healntrack.report_service.transaction.application.port.out.persistence;

import com.sa.healntrack.report_service.transaction.domain.Transaction;

public interface SaveTransaction {
    
    Transaction save(Transaction transaction);

}
