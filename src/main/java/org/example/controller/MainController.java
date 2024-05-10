package org.example.controller;

import java.util.Scanner;

public class MainController {
    private static final String USER_COMMAND = "user";
    private static final String POST_COMMAND = "post";
    private static final String COMMENT_COMMAND = "comment";
    private static final String EXIT = "exit";

    public static void controller() throws CloneNotSupportedException {
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Input your command: ");
            String command = scanner.next();

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
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("No such command");
                    break;
            }
        }
    }
}
