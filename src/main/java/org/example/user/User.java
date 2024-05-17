package org.example.user;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    
    private static final int PRO_USER_THRESHOLD = 50;

    public User(String username, String password) {
        this.id = UserDB.findAll().size();
        this.username = username;
        this.password = password;
    }

    abstract public void upvote();

    public void modify(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }

    public void increaseReputation(int increase) {
        this.reputation += increase;

        if (this instanceof BasicUser && this.reputation >= PRO_USER_THRESHOLD) {

            
            ProUser user = new ProUser();
            user.setId(this.id);
            user.setUsername(this.username);
            user.setPassword(this.password);
            user.setReputation(this.reputation);

            UserDB.delete(this);
            UserDB.create(user);
        }
    }
}
