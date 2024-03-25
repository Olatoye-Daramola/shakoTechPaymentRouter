package com.payaza.shakorouter.repository.query;

public final class TransactionQuery {

    private TransactionQuery() {}

    public static final String READ_ALL = "SELECT DISTINCT t FROM Transaction t";
}
