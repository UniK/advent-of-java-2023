package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Solution {

    public static void main(String... args) {
        out.println("Day one");

        List<String> calibrationValueList = List.of();

        Path path = Paths.get("day01/input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            calibrationValueList = lines
                    .map(line -> line.replaceAll("\\D+", ""))
                    .map(line -> {
                                char firstLetter = line.charAt(0);
                                char lastLetter = line.charAt(line.length() - 1);
                                return "%s%s".formatted(firstLetter, lastLetter);
                            }
                    )
                    .toList();
        } catch (IOException e) {
            out.println("Error reading file");
        }

        Integer sum = calibrationValueList.stream()
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(-1);

        out.println("Answer: " + sum);
    }
}