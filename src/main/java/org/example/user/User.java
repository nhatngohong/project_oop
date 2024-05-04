package org.example.user;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.database.UserDB;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BasicUser.class, name = "BasicUser"),

        @JsonSubTypes.Type(value = ProUser.class, name = "ProUser")}
)
public abstract class User {

    private int id;

    private String username;

    private String password;

    private List<Integer> myPosts;

    private List<Integer> myComments;

    private List<Integer> upvotedPosts;

    private List<Integer> upvotedComments;

    public User(String username, String password) {
        this.id = UserDB.findAll().size();
        this.username = username;
        this.password = password;
        this.myPosts = new ArrayList<>();
        this.myComments = new ArrayList<>();
        this.upvotedPosts = new ArrayList<>();
        this.upvotedComments = new ArrayList<>();
    }

    abstract public void upvote();

    public void update(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }
}
