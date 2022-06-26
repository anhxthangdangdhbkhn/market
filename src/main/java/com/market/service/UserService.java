package com.market.service;

import com.market.domain.Role;
import com.market.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);

    @Transactional
    User getUser(String username);

    List<User> getUsers();

    boolean unlockWhenTimeExpired(User user);
    void lock(User user);
    void increaseFailedAttempts(User user);
    void resetFailedAttempts(String username);
}
