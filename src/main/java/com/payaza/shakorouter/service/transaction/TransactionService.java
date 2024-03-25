package com.payaza.shakorouter.service.transaction;

import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.model.dto.TransactionDto;

public interface TransactionService {

    ApiResponse createTransaction(TransactionDto transactionDto);
    ApiResponse readAllTransactions(int page, int pageSize);
}
