package org.example.user;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class BasicUser extends User {

    public BasicUser(int id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public void upvote() {

    }
}
