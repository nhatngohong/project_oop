package org.example;

import org.example.controller.MainController;
import org.example.database.UserDB;
import org.example.user.User;
import org.example.util.FileUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.out.println(title);

        MainController.controller();

    }
}