package com.abcode.user.controller;

import com.abcode.user.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Eduardo");
        userDTO.setCpf("123");
        userDTO.setAddress("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setPhone("1234-3454");
        userDTO.setDateRegister(new Date());
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setAddress("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setPhone("1234-3454");
        userDTO2.setDateRegister(new Date());
        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setAddress("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setPhone("1234-3454");
        userDTO3.setDateRegister(new Date());
        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }


    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUserFilter(@PathVariable String cpf) {
        for (UserDTO userFilter : users) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }
        }
        return null;
    }
}
