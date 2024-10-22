package com.auth.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTO {
    private String userName;
    private String password;
}
