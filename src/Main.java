import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {
    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();
        checkForAnagramWords();
        final long endTime = System.currentTimeMillis();
        out.println("Timer: " + (endTime - startTime));
    }

    static private void checkForAnagramWords() throws IOException {
        HashMap<String, Set<String>> anagrams = new HashMap<>();
        List<byte[]> wordsInBytes = new ArrayList<>();
        FileChannel inChannel = new FileInputStream("input.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(512);
        Set<char[]> words = new HashSet<>();
        while (inChannel.read(buffer) > 0) {
            buffer.clear();
        }
        out.println(words);
//        anagrams = lines.stream().collect(Collectors.groupingBy(w -> selectionSort(w)));
//        anagrams.entrySet().removeIf(c -> c.getValue().size() <= 1);
//        anagrams.forEach((k, v) -> {
//            out.println(v);
//        });
//        out.println(anagrams.size());
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