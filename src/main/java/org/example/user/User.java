package org.example.user;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.controller.UserController;
import org.example.database.UserDB;

@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BasicUser.class, name = "BasicUser"),

        @JsonSubTypes.Type(value = ProUser.class, name = "ProUser")}
)
public abstract class User {

    private Integer id;

    private String username;

    private String password;

    private int reputation;
    
    private static final int PRO_USER_THRESHOLD = 3;

    public User(String username, String password) {
        this.id = UserDB.findAll().size();
        this.username = username;
        this.password = password;
        this.reputation = 0;
    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.reputation = user.reputation;
    }

    abstract public void upvote();

    public void increaseReputation(int value) {
        User user;
        if (this instanceof BasicUser) {
            user = new BasicUser(this);
        } else {
            user = new ProUser(this);
        }
        user.setReputation(this.getReputation() + value);
        if (user instanceof BasicUser && user.reputation >= PRO_USER_THRESHOLD) {
            user = new ProUser(user);
        }
        UserDB.modify(this, user);
    }
}
