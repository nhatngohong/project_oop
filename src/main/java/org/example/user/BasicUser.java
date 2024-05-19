package org.example.user;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class BasicUser extends User {
    public BasicUser(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setReputation(user.getReputation());
    }

    public BasicUser(String username, String password) {
        super(username, password);
    }

}
