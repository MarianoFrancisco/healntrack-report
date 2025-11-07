package com.sa.healntrack.report_service.transaction.application.port.out.persistence;

import java.util.List;

import com.sa.healntrack.report_service.transaction.application.port.in.get_all_profits.GetAllProfitsQuery;
import com.sa.healntrack.report_service.transaction.domain.TransactionProfit;

public interface FindAllProfits {
    
    List<TransactionProfit> findAll(GetAllProfitsQuery query);

}
