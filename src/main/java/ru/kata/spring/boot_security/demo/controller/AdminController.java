package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.servic.UserService;
import ru.kata.spring.boot_security.demo.servic.RoleService;
import ru.kata.spring.boot_security.demo.entity.User;

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
    public ModelAndView printUser(ModelAndView modelAndView) {
        modelAndView.addObject("userList", userService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/newUserForm")
    public String addUserForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roleList", roleService.findAll());
        return "/newemployee";
    }

    @GetMapping(value = "/updateUserForm")
    public String updateForm(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("roleList", roleService.findAll());
        return "/update";
    }

    @PostMapping(value = "/saveEmployee")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:";
    }

    @PatchMapping (value = "/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:";
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:";
    }
}

