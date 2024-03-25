package com.payaza.shakorouter.repository;

import com.payaza.shakorouter.model.entity.Transaction;
import com.payaza.shakorouter.repository.query.TransactionQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Override @NonNull
    @Query(TransactionQuery.READ_ALL)
    Page<Transaction> findAll(@NonNull Pageable pageable);
}
