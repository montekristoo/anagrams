import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();
        checkForAnagramWords();
        final long endTime = System.currentTimeMillis();
        out.println("Timer: " + (endTime - startTime));
    }

    static private void checkForAnagramWords() throws IOException {
//        List<String> lines = Files.readAllLines(Path.of("input.txt")).stream().distinct().collect(Collectors.toUnmodifiableList());
        Map<String, List<String>> anagrams = Files.readAllLines(Path.of("input.txt")).stream().collect(Collectors.groupingBy(w -> selectionSort(w)));
        anagrams.entrySet().removeIf(c -> c.getValue().size() <= 1);
        anagrams.forEach((k, v) -> {
            out.println(v);
        });
        out.println(anagrams.size());
    }

    public static String sorted(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static String bubbleSort(String word) {
        char[] arrayWord = word.toCharArray();
        boolean ok = true;
        while (ok) {
            ok = false;
            for (int i = 0; i < arrayWord.length-1; i++) {
                if (arrayWord[i] > arrayWord[i+1]) {
                    char aux = arrayWord[i];
                    arrayWord[i] = arrayWord[i+1];
                    arrayWord[i+1] = aux;
                    ok = true;
                }
            }
        }
        return new String(arrayWord);
    }

    public static String selectionSort(String word) {
        char[] arrayWord = word.toCharArray();
        for (int i = 0; i < arrayWord.length; i++) {
            for (int j = i + 1; j < arrayWord.length; j++) {
                if (arrayWord[i] > arrayWord[j]) {
                    char aux = arrayWord[i];
                    arrayWord[i] = arrayWord[j];
                    arrayWord[j] = aux;
                }
            }

        }
        return new String(arrayWord);
    }

}