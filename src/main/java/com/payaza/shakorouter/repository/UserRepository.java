package com.payaza.shakorouter.repository;

import com.payaza.shakorouter.model.entity.User;
import com.payaza.shakorouter.repository.query.UserQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = UserQuery.FIND_BY_USERNAME)
    Optional<User> findByUsername(@Param("username") String username);

    @Query(value = UserQuery.FIND_BY_USERNAME_OR_EMAIL)
    Optional<User> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);
}
