package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;


public class Solution {

    public static void main(String... args) {
        out.println("--- Day 2: Cube Conundrum ---");

        Path path = Paths.get("day02/input.txt");

        List<String> calibrationValueList = List.of();
        try (Stream<String> lines = Files.lines(path)) {
            calibrationValueList = lines.toList();
        } catch (IOException e) {
            out.println("Error reading file");
        }

        calibrationValueList.forEach(out::println);
    }
}
