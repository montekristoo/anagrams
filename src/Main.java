import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Main {

    //to save the words from the file
    static ArrayList<String> words;
    //to save the grouped anagram words
    static Set<Set<String>> anagrams = new HashSet<>();
    public static void main(String[] args) throws IOException {
        checkForAnagramWords();
    }
    static private void checkForAnagramWords() throws IOException {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            int sum = 0;
            int[] ascii = new int[256];
            for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                ascii[(int)c]++;
            }
            for (int i = 0; i < ascii.length; i++) {
                if (ascii[i] > 0) {
                    sum+=i;
                }
            }
                map.computeIfAbsent(sum, k -> new ArrayList<>()).add(line);
        }
        map.forEach((k, v) -> {
            v.forEach(value -> out.print(value + " "));
            out.println();
        });
    }
}