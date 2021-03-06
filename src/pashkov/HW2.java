package pashkov;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) {
        // 2) Ask the user to enter a string and file name. Write line to file.
        System.out.println("Please enter file name and some text that should be written in this file.");
        System.out.print("File name: ");
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String fileName = sb.toString();
        sb.delete(0, sb.length());
        System.out.print("\nText: ");
        sb.append(scanner.nextLine());
        String text = sb.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
