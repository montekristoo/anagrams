import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WordGenerator {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"));
        for (int i = 0; i < 200000000; i++) {
            writer.write(wordGenerator() + '\n');
        }
        writer.close();
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
}
