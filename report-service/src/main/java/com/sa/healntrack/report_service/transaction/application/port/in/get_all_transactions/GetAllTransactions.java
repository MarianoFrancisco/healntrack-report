package com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions;

import java.util.List;

import com.sa.healntrack.report_service.transaction.domain.Transaction;

public interface GetAllTransactions {
    
    List<Transaction> getAll(GetAllTransactionsQuery query);

}
