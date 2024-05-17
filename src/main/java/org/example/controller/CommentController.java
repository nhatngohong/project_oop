package org.example.controller;

import org.example.service.CommentService;

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
            System.out.print("Comment command: ");
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
        if (notSignIn()) return;
        System.out.print("Enter post id you want to comment: ");
        int postId = scanner.nextInt();
        System.out.print("Enter content you want to comment: ");
        String content = scanner.next();
        CommentService.create(postId, content);
    }

    private static void update() {
        if (notSignIn()) return;
        System.out.print("Enter comment id you want to update: ");
        int commentId = scanner.nextInt();
        System.out.print("Enter new content: ");
        String newContent = scanner.next();
        CommentService.update(commentId, newContent);
    }

    private static void delete() {
        if (notSignIn()) return;
        System.out.println("Enter comment id you want to delete: ");
        int commentId = scanner.nextInt();
        CommentService.delete(commentId);
    }

    private static boolean notSignIn() {
        if (UserController.currentUser == null) {
            System.out.println("Please sign in");
            return true;
        }
        return false;
    }
}
