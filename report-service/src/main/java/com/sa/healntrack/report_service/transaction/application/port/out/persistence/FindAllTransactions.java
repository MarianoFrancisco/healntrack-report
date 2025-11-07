package com.sa.healntrack.report_service.transaction.application.port.out.persistence;

import java.util.List;

import com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions.GetAllTransactionsQuery;
import com.sa.healntrack.report_service.transaction.domain.Transaction;

public interface FindAllTransactions {
    
    List<Transaction> findAll(GetAllTransactionsQuery query);

}
