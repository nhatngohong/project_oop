package org.example.service;

import org.example.controller.UserController;
import org.example.database.UserDB;
import org.example.dto.UserCredentialDto;
import org.example.exception.SignInException;
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

        UserDB.save(userSignUp);

    }

    public static void update(UserCredentialDto user) {
        UserController.currentUser.update(user.getUsername(), user.getPassword());
        UserDB.modify(UserController.currentUser);
    }
    public static void upvotePost(User user, int postId) {

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
