package org.example.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileUtil {
    public static <T> List<T> read(String path, Class<T> type) {
        List<T> database = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            Scanner myReader = new Scanner(fileReader);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                database.add(JsonUtil.toObject(data, type));
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        return database;
    }

    public static <T> void write(T object, String path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(JsonUtil.toJson(object) + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static <T> void modify(String path, T object, T modifiedObject, Class<T> type) {

        File file = new File(path);

        List<T> database = read(path, type);

        for (T data: database) {
            if (data.equals(object)) {
                data = modifiedObject;
            }
        }

        List<String> lines = database
                .stream()
                .map(JsonUtil::toJson)
                .collect(Collectors.toList());
        try {
            Path filePath = Paths.get(path);
            Files.write(filePath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void delete(String path, T object, Class<T> type) {

        File file = new File(path);
        List<T> database = read(path, type);
        database.removeIf(data -> data.equals(object));
        List<String> lines = database
                .stream()
                .map(JsonUtil::toJson)
                .collect(Collectors.toList());
        try {
            Path filePath = Paths.get(path);
            Files.write(filePath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
