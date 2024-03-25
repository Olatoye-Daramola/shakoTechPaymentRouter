package com.payaza.shakorouter.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class TransactionDto {

    @NotEmpty(message = "Session Id is required")
    private String sessionId;
    @NotEmpty(message = "Account is required")
    private String accountNumber;
    @NotNull(message = "Transaction Amount is required")
    private BigDecimal transactionAmount;
    private BigDecimal vatAmount;
    private BigDecimal feeAmount;
    @NotNull(message = "Settled Amount is required")
    private BigDecimal settledAmount;
    @NotEmpty(message = "Settlement Id is required")
    private String settlementId;
    private String sourceAccountNumber;
    private String sourceAccountName;
    private String sourceBankCode;
    private String transactionRemark;

    @Override
    public String toString() {
        try {
            return new Gson().toJson(this);
        } catch (Exception ex) {
            return super.toString();
        }
    }
}

