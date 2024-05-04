package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.CommentController;
import org.example.controller.PostController;
import org.example.controller.UserController;
import org.example.user.BasicUser;
import org.example.user.ProUser;
import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String USER_COMMAND = "user";
    private static final String POST_COMMAND = "post";
    private static final String COMMENT_COMMAND = "comment";
    private static final String EXIT = "exit";

    public static void main(String[] args) {

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