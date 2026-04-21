package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngine {
    public static void logAction(String action) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));

            // timestamps
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(fmt);

            //the log entry
            writer.write(timestamp + " " + action);
            writer.newLine();

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // the log launch
        logAction("launch");

        String term;

        while (true) {
            System.out.print("Enter a search term (X to exit): ");
            term = scanner.nextLine();

            if (term.equalsIgnoreCase("X")) {
                logAction("exit");
                System.out.println("Goodbye.");
                break;
            }
            logAction("search : " + term);
        }

    }
}