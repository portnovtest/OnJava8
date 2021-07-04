package compression;

// {java GZIPcompress GZIPcompress.java}
// {VisuallyInspectOutput}

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: \nGZIPcompress file\n\tUses GZIP compression to compress the file to test.gz");
            System.exit(1);
        }
        try (InputStream in = new BufferedInputStream(new FileInputStream(args[0]));
             BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("src/main/java/compression/test.gz")))) {
            System.out.println("Writing file");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Reading file");
        try (BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("src/main/java/compression/test.gz"))))) {
            in2.lines().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
