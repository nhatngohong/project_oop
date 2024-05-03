package org.example.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ProUser extends User {
    public void addTag() {
        System.out.println("u can add tag");
    }

    @Override
    public void upvote() {

    }
}
