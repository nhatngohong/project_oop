package org.example.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static <T> void add(T object, String path) {
        try {
            FileWriter myWriter = new FileWriter(path, true);
            myWriter.write(JsonUtil.toJson(object) + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void modify(String path, int id, String modifiedObject) {
        try {
            Path filePath = Paths.get(path);
            List<String> lines = Files.readAllLines(filePath);
            lines.set(id, modifiedObject);
            Files.write(filePath, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
