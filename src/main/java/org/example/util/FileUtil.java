package org.example.util;

import com.google.gson.Gson;
import org.example.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    public static <T>  List<T> read(String path, Class<T> type)  {
        List<T> objects = new ArrayList<>();
        try {
            FileReader myObj = new FileReader(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                T object = (T) JsonUtil.toObject(data, type);
                objects.add(object);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return objects;
    }
    public static <T> void write(T object, String path, Class<T> type) {
        try {
            FileWriter myWriter = new FileWriter(path, true);
            myWriter.write("\n");
            myWriter.write(JsonUtil.toJson(object));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
