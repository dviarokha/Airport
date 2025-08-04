package FileTask;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import static org.apache.commons.io.FileUtils.*;

public class Main {
    public static void main(String[] args) {
        try {
            File source = new File("/Users/dashaviarokha/IdeaProjects/test1/src/main/java/FileTask/Airport.txt");
            File target = new File("/Users/dashaviarokha/IdeaProjects/test1/src/main/java/FileTask/Airport2.txt");

            String line = FileUtils.readFileToString(source, "UTF-8");

            Map<String, Integer> uniqueUpdateLine = new HashMap<>();
            for (String word : line.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+")) {
            if (!word.isEmpty()) {
                uniqueUpdateLine.put(word, uniqueUpdateLine.getOrDefault(word, 0) + 1);
            }
            }

            String result = uniqueUpdateLine.entrySet()
                    .stream()
                    .map(e -> e.getKey() + " - " + e.getValue())
                    .collect(Collectors.joining(System.lineSeparator()));

            FileUtils.writeStringToFile(target, result, "UTF-8");

            Runtime.getRuntime().exec(new String[]{"open", target.getAbsolutePath()});

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}