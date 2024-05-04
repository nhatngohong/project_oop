package org.example.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    public static String read(String path) {
        String database = null;
        try {
            FileReader fileReader = new FileReader(path);
            Scanner myReader = new Scanner(fileReader);
            while (myReader.hasNextLine()) {
                database = myReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        return database;
    }

    public static <T> void write(T object, String path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(JsonUtil.toJson(object));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
