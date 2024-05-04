package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.CommentController;
import org.example.controller.MainController;
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
    public static void main(String[] args) {
        MainController.controller();
        System.out.println("Hello");
    }

}