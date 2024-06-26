package com.payaza.shakorouter.service.transaction;

import com.google.gson.Gson;
import com.payaza.shakorouter.config.multitenant.TenantContext;
import com.payaza.shakorouter.model.constant.CountryCode;
import com.payaza.shakorouter.model.constant.TransactionStatus;
import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.model.dto.Pagination;
import com.payaza.shakorouter.model.dto.TransactionDto;
import com.payaza.shakorouter.model.entity.Transaction;
import com.payaza.shakorouter.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.payaza.shakorouter.util.CustomLogger.logInfo;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ApiResponse createTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Gson().fromJson(new Gson().toJson(transactionDto), Transaction.class);
        transaction.setReferenceNumber(UUID.randomUUID().toString());
        //save transaction
        transaction.setCountry(CountryCode.getCountryCode(TenantContext.getTenantId()));
        transaction.setStatus(TransactionStatus.INITIATED);
        logInfo("TransactionService.createTransaction", "TenantContext.getTenantId() ==> " + TenantContext.getTenantId());
        logInfo("TransactionService.createTransaction","TenantContext.Transaction ==> " + transaction.toString());
        transactionRepository.save(transaction);
        //call MgTech API here
        transaction.setStatus(TransactionStatus.SUCCESSFUL);
        transactionRepository.save(transaction);
        //return response
        TransactionDto responseData = new Gson().fromJson(new Gson().toJson(transaction), TransactionDto.class);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("success");
        apiResponse.setResponseData(responseData);
        return apiResponse;
    }

    @Override
    public ApiResponse readAllTransactions(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Transaction> pageOfTransactions = transactionRepository.findAll(pageable);
        Pagination pagination = new Pagination(pageOfTransactions.getSize(), pageOfTransactions.getNumber(),
                pageOfTransactions.getTotalPages());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResponseData(pageOfTransactions.getContent());
        apiResponse.setPagination(pagination);
        return apiResponse;
    }
}
