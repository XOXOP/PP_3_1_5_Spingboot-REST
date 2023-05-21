package ru.kata.spring.boot_security.demo.util;


import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.servic.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.servic.UserServiceImpl;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitiateUtil {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public InitiateUtil(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostConstruct
    private void postConstruct() {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role( "USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);
        User admin = new User("2x0iii@hotmail.net", "0001", "dummy-user",
                "User-is-dummy", 22, Set.of(roleAdmin, roleUser));

        User user = new User("10nr12s@hotmail.com", "0002", "headless-user",
                "userWithoutH", 100, Set.of(roleUser));
        User user1 = new User("15krwwv@hotmail.net", "0003", "asleep-user",
                "User-fell-asleep", 15, Set.of(roleUser));
        userService.addUser(admin);
        userService.addUser(user);
        userService.addUser(user1);

    }
}

