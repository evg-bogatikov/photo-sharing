package com.evg.photosharing.security.payload.response;

import com.evg.photosharing.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TokenResponse {
    private String token;
    private String refreshToken;
    private String id;
    private String email;
    private String username;
    private Set<Role> roleSet;
}
