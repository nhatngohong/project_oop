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
}
