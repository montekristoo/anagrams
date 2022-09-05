import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {

    static ArrayList<String> words = new ArrayList<>();
    static Set<Set<String>> groupedAnagrams = new HashSet<>();
    static ArrayList<String> sortedWords = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Instant start = Instant.now();
        generatingWords();
        displayWords();
        Instant end = Instant.now();
        System.out.println("Duration with bubble sort: " + Duration.between(start, end));
    }

    private static void displayWords() {
        findAnagrams();
        groupedAnagrams.forEach((row) -> {
            row.forEach((value) -> System.out.print(value + " "));
            System.out.println();
        });
    }

    private static void generatingWords() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line);
            sortedWords.add(selectionSort(line));
        }
        reader.close();
    }

    private static String wordGenerator() {
        Random random = new Random();
        int wordSize = random.nextInt(10);
        char[] word = new char[wordSize];
        for (int j = 0; j < wordSize; j++) {
            char character = (char)(random.nextInt(26) + 'a');
            word[j] = character;
        }
        return String.valueOf(word);
    }

    private static void findAnagrams() {
        HashMap<String, ArrayList<Integer>> wordsByIndex = new HashMap<>();
        for (int i = 0; i < sortedWords.size(); i++) {
            wordsByIndex.computeIfAbsent(sortedWords.get(i), k -> new ArrayList<>()).add(i);
        }
        wordsByIndex.forEach((key, value) -> {
            Set<String> anagrams = new HashSet<>();
            if (value.size() > 1) {
                value.forEach((index) -> {
                    anagrams.add(words.get(index));
                });
                groupedAnagrams.add(anagrams);
            }
        });
    }

    private static String javaSort(String word) {
        char[] arrayWord = word.toCharArray();
        Arrays.sort(arrayWord);
        return String.valueOf(arrayWord);
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
       return String.valueOf(arrayWord);
    }

    public static String selectionSort(String word) {
        char[] arrayWord = word.toCharArray();
        for(int i = 0; i < arrayWord.length; i++) {
            for (int j = i+1; j < arrayWord.length; j++) {
                if (arrayWord[i] > arrayWord[j]) {
                    char aux = arrayWord[i];
                    arrayWord[i] = arrayWord[j];
                    arrayWord[j] = aux;
                }
            }
        }
        return String.valueOf(arrayWord);
    }

}
