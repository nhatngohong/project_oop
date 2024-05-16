package org.example.controller;

import org.example.database.PostDB;
import org.example.dto.PostDetailDto;
import org.example.dto.PostSimpleDto;
import org.example.post.Post;
import org.example.service.PostService;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;
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
            System.out.print("Post command: ");
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
        List<PostSimpleDto> allPost = PostService.getAll();
        for (var post : allPost) {
            System.out.println(JsonUtil.toPrettyJson(post));;
        }
    }

    private static void getById(){
        System.out.println("Input ID post: ");
        int id = scanner.nextInt();
        PostDetailDto post = PostService.getById(id);
        System.out.println(JsonUtil.toPrettyJson(post));
    }



    private static void create() {
        if (UserController.currentUser == null){
            System.out.println("Please log in");
            return;
        }
        else{
            Post newPost = createNewpost();
            PostService.create(newPost);
        }
    }

    private static void update() {
        if (UserController.currentUser == null){
            System.out.println("Please log in");
            return;
        }
        else{
            System.out.println("Input ID post you want to update: ");
            Integer ID = scanner.nextInt();
            Post updatePost = createNewpost();
            PostService.update(ID, updatePost);
        }
    }

    private static void delete() {
        if (UserController.currentUser == null){
            System.out.println("Please log in");
            return;
        }
        else{
            System.out.println("Input ID post you want to delete: ");
            Integer ID = scanner.nextInt();
            PostService.delete(ID);
        }
    }
    private static Post createNewpost (){
        System.out.println("Input title: ");
        String title = scanner.next();
        System.out.println("Input content: ");
        String content = scanner.next();
        return new Post(
                title,
                content,
                UserController.currentUser.getId()
        );
    }
}
