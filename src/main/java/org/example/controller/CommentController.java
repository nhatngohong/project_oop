package org.example.controller;

import org.example.service.CommentService;
import org.example.user.User;

import java.util.Scanner;

public class CommentController {

    private static final String CREATE = "create";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String EXIT = "exit";

    private static final Scanner scanner = new Scanner(System.in);

    public static void controller() {

        boolean exit = false;

        while (!exit) {
            System.out.print("User command: ");
            String command = scanner.next();

            switch (command) {
                case CREATE:
                    create();
                    break;
                case UPDATE:
                    update();
                    break;
                case DELETE:
                    delete();
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

    private static void create() {
        System.out.println("cai dat 1 j do quan trong");
    }

    private static void update() {

    }

    private static void delete() {

    }
}
