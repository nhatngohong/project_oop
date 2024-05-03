package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCredentialDto {
    private String username;

    private String password;
}
