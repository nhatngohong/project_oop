package org.example.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ProUser extends User {
    public ProUser(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setReputation(user.getReputation());
    }

}
