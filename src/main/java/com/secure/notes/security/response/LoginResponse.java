package com.secure.notes.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String jwtToken;
    private String username;
    private List<String> roles;

}
