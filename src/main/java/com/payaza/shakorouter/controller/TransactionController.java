package com.payaza.shakorouter.controller;

import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.model.dto.TransactionDto;
import com.payaza.shakorouter.service.transaction.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.payaza.shakorouter.util.CustomLogger.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createTransaction(@NotNull(message = "Valid request body is required") @Valid
                                                         @RequestBody TransactionDto request, @ApiIgnore Errors errors) {
        logRequest("TransactionController.createTransaction", request.toString());
        logError(errors);
        ApiResponse response = transactionService.createTransaction(request);
        logResponse("TransactionController.createTransaction", response.toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/read")
    public ResponseEntity<ApiResponse> readAllTransactions(@RequestParam(defaultValue = "0", required = false) int page,
                                                           @RequestParam(defaultValue = "10", required = false) int pageSize
    ) {
        ApiResponse response = transactionService.readAllTransactions(page, pageSize);
        logResponse("TransactionController.readAllTransactions", response.toString());
        return ResponseEntity.ok(response);
    }
}
