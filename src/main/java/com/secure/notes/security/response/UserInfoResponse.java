package com.secure.notes.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

    private Long id;
    private String username;
    private String email;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private LocalDate credentialsExpiryDate;
    private LocalDate accountExpiryDate;
    private boolean isTwoFactorEnabled;
    private List<String> roles;

    /*public UserInfoResponse(Long userId, String userName, boolean accountNonExpired, boolean accountNonExpired1, boolean credentialsNonExpired, boolean enabled, LocalDate credentialsExpiryDate, LocalDate accountExpiryDate, boolean twoFactorEnabled, List<String> roles) {
    }*/
}
