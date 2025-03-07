package com.yupi.yupicturebackend.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -7041229303630642331L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
