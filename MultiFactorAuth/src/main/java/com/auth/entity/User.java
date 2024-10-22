package com.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SEC_USER")
public class User {
    @Id
    private int id;
    private String userName;
    private String password;
    private String roles;
}