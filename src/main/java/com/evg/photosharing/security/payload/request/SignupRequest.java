package com.evg.photosharing.security.payload.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignupRequest {

    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 10, max = 50)
    private String password;
    @Email
    private String email;

}
