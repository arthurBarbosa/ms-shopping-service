package com.abcode.user.service;

import com.abcode.user.dto.UserDTO;
import com.abcode.user.entity.User;
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

    public UserDTO save(UserDTO userDTO) {
        var user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    public UserDTO delete(Long id) {
        var user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        var user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        var users = userRepository.queryByNameLike(name);
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

}
