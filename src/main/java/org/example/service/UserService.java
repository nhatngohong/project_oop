package org.example.service;

import org.example.comment.Comment;
import org.example.controller.UserController;
import org.example.database.UserDB;
import org.example.dto.UserCredentialDto;
import org.example.post.Post;
import org.example.user.BasicUser;
import org.example.user.User;

import java.util.List;

public class UserService {
    public static void signin(UserCredentialDto userCredential) {

        List<User> users = UserDB.findAll();

        UserController.currentUser = getUserSignIn(userCredential, users);

    }

    public static void signup(UserCredentialDto userCredential) {

        BasicUser userSignUp = getUserSignUp(userCredential);

        UserDB.create(userSignUp);

    }

    public static void update(UserCredentialDto user) {
        

    }

    public static void upvotePost(User user, Post post) {

    }

    public static void upvoteComment(User user, Comment comment) {

    }

    private static User getUserSignIn(UserCredentialDto userCredential, List<User> database) {

        String username = userCredential.getUsername();
        String password = userCredential.getPassword();

        for (User user : database) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        //TODO fix
        System.out.println("Incorrect username or password");
        return null;
    }

    private static BasicUser getUserSignUp(UserCredentialDto signUpUser) {

        return new BasicUser(
                signUpUser.getUsername(),
                signUpUser.getPassword()
        );
    }
}
