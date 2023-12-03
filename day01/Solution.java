package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Solution {

    public static void main(String... args) {
        out.println("--- Day 1: Trebuchet?! ---");

        Path path = Paths.get("day01/input.txt");

        out.println("Answer, part one: " + partOneSolution(path));
        out.println("Answer, part two: " + partTwoSolution(path));
    }

    private static Integer partOneSolution(Path path) {
        List<String> calibrationValueList = List.of();
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

        return calibrationValueList.stream()
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    private static Integer partTwoSolution(Path path) {
        List<String> calibrationValueList = List.of();
        try (Stream<String> lines = Files.lines(path)) {
            calibrationValueList = lines
                    .map(Solution::translateStringsToNumbers)
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

        return calibrationValueList.stream()
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    private static String translateStringsToNumbers(String line) {

        Map<String, String> translationMap = Map.of(
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9",
                "zero", "0"
        );

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (Character.isDigit(currentChar)) {
                sb.append(currentChar);
            } else {
                for (String key : translationMap.keySet()) {
                    if (line.substring(i).startsWith(key)) {
                        sb.append(translationMap.get(key));
                    }
                }
            }
        }
        return sb.toString();
    }
}