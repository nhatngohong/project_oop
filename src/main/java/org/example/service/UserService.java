package org.example.service;

import org.example.controller.UserController;
import org.example.database.UserDB;
import org.example.dto.UserCredentialDto;
import org.example.exception.SignInException;
import org.example.user.BasicUser;
import org.example.user.User;
import org.example.util.FileUtil;

import java.util.List;

public class UserService {
    public static void signin(UserCredentialDto userCredential) {

        List<User> users = UserDB.findAll();
        UserController.currentUserId = getUserSignIn(userCredential, users);

    }

    public static void signup(UserCredentialDto signUpUser) {

        BasicUser user = new BasicUser(
                UserDB.findAll().size(),
                signUpUser.getUsername(),
                signUpUser.getPassword());
        FileUtil.write(user, "userdb.txt", User.class);
    }

    private static int getUserSignIn(UserCredentialDto userCredential, List<User> database) {
        String username = userCredential.getUsername();
        String password = userCredential.getPassword();
        for (User user : database) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        //TODO fix
        throw new SignInException("Incorrect username or password");
    }
}
