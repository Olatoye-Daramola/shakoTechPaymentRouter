package com.payaza.shakorouter.repository.query;

public final class UserQuery {

    private UserQuery() {}

    public static final String FIND_BY_USERNAME = "SELECT user FROM User user where user.username = :username";

    public static final String FIND_BY_USERNAME_OR_EMAIL = "SELECT user FROM User user WHERE user.username = :username " +
            "OR user.email = :email";
}
