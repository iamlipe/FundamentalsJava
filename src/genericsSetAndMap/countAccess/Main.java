package genericsSetAndMap.countAccess;


import genericsSetAndMap.countAccess.entities.LogEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "/src/genericsSetAndMap/countAccess/input/users.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();

            while (line != null) {
                String username = line.split(" ")[0];
                Instant instant = Instant.parse(line.split(" ")[1]);
                LocalDateTime moment = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

                LogEntry logEntry = new LogEntry(username, moment);

                set.add(logEntry);

                line = br.readLine();
            }

            System.out.println("Total de usuarios: " + set.size());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
