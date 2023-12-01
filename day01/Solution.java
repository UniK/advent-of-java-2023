package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Solution {

    public static void main(String... args) {
        out.println("Day one");

        Path path = Paths.get("day01/example.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(out::println);
        } catch (IOException e) {
            out.println("Error reading file");
        }
    }
}