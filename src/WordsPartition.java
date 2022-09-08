import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordsPartition {
    public static void Partition(String file) throws IOException {
        File initialFile = new File(file);
        try (Stream<String> lines = Files.lines(Paths.get(file), Charset.defaultCharset())) {
            lines.forEachOrdered((line) -> {
                try {
                    pathToFile(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static void pathToFile(String word) throws IOException {
        File file = new File("C:\\Users\\GDB-01\\Desktop\\" + word.charAt(0) + ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write("i" + "\n");
        writer.close();
    }

}
