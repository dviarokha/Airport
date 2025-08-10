package FileTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Set<String> uniqueWords = Files.lines(Paths.get("/Users/dashaviarokha/IdeaProjects/test1/src/main/java/FileTask/Airport.txt"))
                .flatMap(line -> Arrays.stream(line.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+")))
                .collect(Collectors.toSet());
        uniqueWords.forEach(System.out::println);
    }
}