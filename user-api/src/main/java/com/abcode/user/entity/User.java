package com.abcode.user.entity;

import com.abcode.user.dto.UserDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private Date dateRegister;

    public static User convert(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .cpf(userDTO.getCpf())
                .address(userDTO.getAddress())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .dateRegister(userDTO.getDateRegister())
                .build();
    }
}
