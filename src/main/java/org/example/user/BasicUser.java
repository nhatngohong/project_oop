package org.example.user;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class BasicUser extends User {

    public BasicUser(String username, String password) {
        super(username, password);
    }

    @Override
    public void upvote() {

    }
}
