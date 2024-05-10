package org.example.controller;

import org.example.post.Post;
import org.example.service.PostService;
import org.example.user.User;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.Scanner;
import java.lang.Cloneable;


public class PostController {

    private static final String GET_ALL = "getall";
    private static final String GET_BY_ID = "getbyid";
    private static final String CREATE = "create";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String EXIT = "exit";

    private static final Scanner scanner = new Scanner(System.in);

    public static void controller() throws CloneNotSupportedException {

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
        if (UserController.currentUser == null) {
            System.out.println("Please log in");
            return;
        } else {
            List<Post> allPost = PostService.getAll();
            for (var post : allPost) System.out.println(JsonUtil.toPrettyJson(post));
        }
    }

    private static void getById() {
        if (UserController.currentUser == null) {
            System.out.println("Please log in");
            return;
        } else {
            System.out.println("Input post ID: ");
            int ID = scanner.nextInt();
            boolean found = false;
            List<Post> allPost = PostService.getAll();
            for (var post : allPost) {
                if (post.getId() == ID) {
                    found = true;
                    Post idPost = PostService.getById(ID);
                    System.out.println(JsonUtil.toPrettyJson(idPost));
                    break;
                }

            }
            if (!found) {
                System.out.println("Don't find the post ID");
                return;
            }
        }
    }

    private static void create() {
        if (UserController.currentUser == null) {
            System.out.println("Please log in");
            return;
        } else {
            User currentUser = UserController.currentUser;
            Post newPost = inputNewPost((currentUser.getId()));
            PostService.create(newPost);

        }

    }
    private static void update() throws CloneNotSupportedException {
        if (UserController.currentUser == null) {
            System.out.println("Please log in");
            return;
        }
        else{
            User currentUser = UserController.currentUser;
            System.out.println("Input post ID you want to update: ");
            int ID = scanner.nextInt();
            boolean found = false;
            List<Post> allPost = PostService.getAll();
            for (var post:allPost){
                if (post.getId() == ID){
                    found = true;
                    Post modifiedPost = modifedPost(post);
                    //Post modifiedPost = inputNewPost(UserController.currentUser.getId());
                    PostService.update(post, modifiedPost);
                    break;
                }

            }
            if (!found){
                System.out.println("Don't find the post ID");
                return;
            }
        }
    }

    private static void delete() {
        if (UserController.currentUser == null) {
            System.out.println("Please log in");
            return;
        } else {
            User currentUser = UserController.currentUser;
            System.out.println("Input post ID you want to delete: ");
            int ID = scanner.nextInt();
            boolean found = false;
            List<Post> allPost = PostService.getAll();
            for (var post : allPost) {
                if (post.getId() == ID) {
                    found = true;
                    PostService.delete(post);
                    break;
                }

            }
            if (!found) {
                System.out.println("Don't find the post ID");
                return;
            }
        }
    }


    private static Post inputNewPost(int userId) {
        System.out.println("Input post title:");
        String title = scanner.next();
        System.out.println("Input post content:");
        String content = scanner.next();

        return new Post(title, content, userId);
    }

    private static Post modifedPost(Post post) throws CloneNotSupportedException {
        Post modifiedPost = (Post) post.clone();
        System.out.println("Input post title:");
        String title = scanner.next();
        modifiedPost.setTitle(title);
        System.out.println("Input post content:");
        String content = scanner.next();
        modifiedPost.setContent(content);
        return modifiedPost;
    }
}

