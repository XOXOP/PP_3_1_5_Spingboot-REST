package ru.kata.spring.boot_security.demo.servic;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserById(long id);

    void save(User user);
    void deleteUserById(long id);

    void updateUser(User newUser);
    User findUserByEmail(String email);

}













