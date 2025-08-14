package FileTask;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Long> uniqueLine = Files.lines(Paths.get("/Users/dashaviarokha/IdeaProjects/test1/src/main/java/FileTask/Airport.txt"))
                .flatMap(line -> Arrays.stream(line.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        uniqueLine.forEach((word, count) -> System.out.println(word + " - " + count));

        var words = uniqueLine.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.toList());

        Files.write(Paths.get("/Users/dashaviarokha/IdeaProjects/test1/src/main/java/FileTask/Airport2.txt"), words);

    }
}