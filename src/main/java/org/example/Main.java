package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.CommentController;
import org.example.controller.PostController;
import org.example.controller.UserController;
import org.example.user.BasicUser;
import org.example.user.ProUser;
import org.example.user.User;

import java.util.Scanner;

public class Main {
    private static final String USER_COMMAND = "user";
    private static final String POST_COMMAND = "post";
    private static final String COMMENT_COMMAND = "comment";

    public static void main(String[] args) {


        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Input your command: ");
            String command = scanner.nextLine();

            switch (command) {
                case USER_COMMAND:
                    UserController.controller();
                    break;
                case POST_COMMAND:
                    PostController.controller();
                    break;
                case COMMENT_COMMAND:
                    CommentController.controller();
                    break;
            }
        }

    }

}