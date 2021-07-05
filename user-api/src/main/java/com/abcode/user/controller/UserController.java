package com.abcode.user.controller;

import com.abcode.user.dto.UserDTO;
import com.abcode.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUserFilter(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @PostMapping("/users")
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public UserDTO remove(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/users/search")
    public List<UserDTO> queryByName(@RequestParam(name = "name", required = true) String name) {
        return userService.queryByName(name);
    }
}
