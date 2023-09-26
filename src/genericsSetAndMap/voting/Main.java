package genericsSetAndMap.voting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Map<String, Integer> candidates = new LinkedHashMap<>();

        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "/src/genericsSetAndMap/voting/input/votes.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                String candidate = line.split(",")[0];
                int votes = Integer.parseInt(line.split(",")[1]);


                if (candidates.containsKey(candidate)) {
                    candidates.put(candidate, candidates.get(candidate) + votes);
                } else {
                    candidates.put(candidate, votes);
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (String key : candidates.keySet()) {
            System.out.println(key + ": " + candidates.get(key));
        }
    }
}
