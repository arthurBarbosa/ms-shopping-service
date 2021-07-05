package com.abcode.user.service;

import com.abcode.user.dto.UserDTO;
import com.abcode.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream().map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        var user = userRepository.findById(id);
        return user.map(UserDTO::convert).orElse(null);
    }

}
