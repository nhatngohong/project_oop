package org.example.controller;

import lombok.Getter;
import org.example.dto.UserCredentialDto;
import org.example.service.UserService;
import org.example.user.User;

import java.util.Scanner;

@Getter
public class UserController {

    public static User currentUser = null;

    private static final String SIGN_IN = "signin";

    private static final String SIGN_UP = "signup";

    private static final String EXIT = "exit";

    private static final Scanner scanner = new Scanner(System.in);

    public static void controller() {


        boolean exit = false;

        while (!exit) {
            System.out.println("User command: ");
            String command = scanner.nextLine();

            switch (command) {
                case SIGN_IN:
                    signin();
                    break;
                case SIGN_UP:
                    signup();
                    break;
                case EXIT:
                    exit = true;
                    break;
            }
        }

    }

    private static void signin() {

        System.out.println("Sign in :");
        UserCredentialDto user = inputCredential();

        UserService.signin(user);

        System.out.println("Successfully sign in");
    }

    private static void signup() {

        System.out.println("Sign up :");
        UserCredentialDto signUpUser = inputCredential();

        UserService.signup(signUpUser);

        System.out.println("Successfully sign up");
    }

    private static void upvotePost(User user) {

        int postId = scanner.nextInt();
        UserService.upvotePost(user, postId);
    }

    private static UserCredentialDto inputCredential() {

        System.out.print("Enter your username:");
        String username = scanner.next();
        System.out.print("Enter your password:");
        String password = scanner.next();

        return new UserCredentialDto(username, password);
    }
}
