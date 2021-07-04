package com.abcode.user.dto;

import com.abcode.user.entity.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private Date dateRegister;

    public static UserDTO convert(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .cpf(user.getCpf())
                .address(user.getAddress())
                .phone(user.getPhone())
                .dateRegister(user.getDateRegister())
                .build();
    }
}
