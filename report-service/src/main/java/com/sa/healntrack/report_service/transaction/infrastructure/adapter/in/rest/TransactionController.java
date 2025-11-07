package com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.healntrack.report_service.transaction.application.port.in.get_all_transactions.GetAllTransactions;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto.SearchTransactionsRequestDTO;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.dto.TransactionResponseDTO;
import com.sa.healntrack.report_service.transaction.infrastructure.adapter.in.rest.mapper.TransactionRestMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
@RestController
public class TransactionController {
    
    private final TransactionRestMapper mapper;
    private final GetAllTransactions getAllTransactions;

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAll(
            SearchTransactionsRequestDTO requestDTO) {
        List<TransactionResponseDTO> transactions = getAllTransactions
                    .getAll(mapper.toQuery(requestDTO))
                    .stream()
                    .map(mapper::fromDomain)
                    .toList();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

}
