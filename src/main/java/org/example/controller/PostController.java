package org.example.controller;

import java.util.Scanner;

public class PostController {

    private static final String GET_ALL = "getall";
    private static final String GET_BY_ID = "getbyid";
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
                case GET_ALL:
                    getAll();
                    break;
                case GET_BY_ID:
                    getById();
                    break;
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

    private static void getAll() {

    }

    private static void getById() {

    }

    private static void create() {

    }

    private static void update() {

    }

    private static void delete() {

    }
}
