package com.gmail.chiyc88.finalproject.readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\LD\\IdeaProjects\\final-project-for-1092-java2-HappyGroupHub\\src\\main\\java\\com\\gmail\\chiyc88\\finalproject\\readfile\\config.txt");
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        }
    }
}
