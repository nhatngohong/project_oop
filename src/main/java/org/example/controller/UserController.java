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

    private static final String UPDATE = "update";

    private static final String ADD_TAG = "addtag";

    private static final String EXIT = "exit";

    private static final Scanner scanner = new Scanner(System.in);

    public static void controller() {


        boolean exit = false;

        while (!exit) {
            System.out.print("User command: ");
            String command = scanner.next();

            switch (command) {
                case SIGN_IN:
                    signin();
                    break;
                case SIGN_UP:
                    signup();
                    break;
                case UPDATE:
                    update();
                    break;
                case ADD_TAG:
                    addTag();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Command does not exist");
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

    private static void update() {
        System.out.println("Update username and password");

        UserCredentialDto user = inputCredential();

        UserService.update(user);
    }

    private static void addTag() {
        System.out.println("Input tag id:  ");
        int tagId = scanner.nextInt();
        System.out.println("Input post id:  ");
        int postId = scanner.nextInt();

        UserService.addTag(tagId, postId);
    }

    private static UserCredentialDto inputCredential() {

        System.out.print("Input your username:");
        String username = scanner.next();
        System.out.print("Input your password:");
        String password = scanner.next();

        return new UserCredentialDto(username, password);
    }
}
