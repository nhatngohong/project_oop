package org.example;

import org.example.controller.MainController;
import org.example.database.UserDB;
import org.example.post.Post;
import org.example.user.BasicUser;
import org.example.user.ProUser;
import org.example.user.User;
import org.example.util.FileUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User user = UserDB.findById(1);

        MainController.controller();

    }
}