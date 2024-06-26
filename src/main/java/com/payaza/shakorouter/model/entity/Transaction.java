package com.payaza.shakorouter.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.payaza.shakorouter.model.constant.CountryCode;
import com.payaza.shakorouter.model.constant.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "transactions",
        uniqueConstraints = @UniqueConstraint(columnNames = {"referenceNumber", "sessionId", "settlementId"}),
        indexes = @Index(columnList = "id, status, sessionId, referenceNumber, transactionDate"))
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CountryCode country;

    @Column(nullable = false, unique = true, length = 36)
    private String referenceNumber;

    @Column(nullable = false, unique = true, length = 36)
    private String sessionId;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false, scale = 2)
    private BigDecimal transactionAmount;

    @Column(nullable = false, scale = 2)
    private BigDecimal vatAmount;

    @Column(nullable = false, scale = 2)
    private BigDecimal feeAmount;

    @Column(nullable = false, scale = 2)
    private BigDecimal settledAmount;

    @Column(unique = true)
    private String settlementId;

    private String sourceAccountNumber;
    private String sourceAccountName;
    private String sourceBankCode;

    @Column(length = 100)
    private String transactionRemark;

    @CreationTimestamp
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+1")
    private Timestamp transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Override
    public String toString() {
        try {
            return new Gson().toJson(this);
        } catch (Exception ex) {
            return super.toString();
        }
    }
}
