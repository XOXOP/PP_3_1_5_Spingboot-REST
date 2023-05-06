package ru.kata.spring.boot_security.demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.servic.RoleService;
import ru.kata.spring.boot_security.demo.servic.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String starterPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findUserByEmail(userDetails.getUsername());
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("user", user);
        return "admin";
    }


    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:";
    }

    @PatchMapping (value = "/update")
    public String updateUser(@ModelAttribute("user") User user) {

        userService.updateUser(user);
        return "redirect:";
    }


    @DeleteMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:";
    }


}



