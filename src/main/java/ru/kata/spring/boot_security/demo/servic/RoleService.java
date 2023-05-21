package ru.kata.spring.boot_security.demo.servic;

import java.util.List;
import ru.kata.spring.boot_security.demo.entity.Role;
public interface RoleService {

    List<Role> getAllRoles();

    void deleteRoleById(Long id);

    void addRole(Role role);
}