package com.abcode.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String cpf;
    private String Address;
    private String email;
    private String phone;
    private Date dateRegister;
}
