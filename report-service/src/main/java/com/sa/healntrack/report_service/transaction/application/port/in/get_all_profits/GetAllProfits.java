package com.sa.healntrack.report_service.transaction.application.port.in.get_all_profits;

import java.util.List;

import com.sa.healntrack.report_service.transaction.domain.TransactionProfit;

public interface GetAllProfits {
    
    List<TransactionProfit> getAll(GetAllProfitsQuery query);

}
