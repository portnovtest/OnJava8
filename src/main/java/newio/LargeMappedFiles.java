package newio;

// Creating a very large file using mapping

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {
    static int length = 0x8000000; // 128 MB

    public static void main(String[] args) throws Exception {
        try (RandomAccessFile tdat = new RandomAccessFile("src/main/java/newio/test.dat", "rw")) {
            MappedByteBuffer out = tdat.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
            for (int i = 0; i < length; i++) {
                out.put((byte) 'x');
            }
            System.out.println("Finished writing");
            for (int i = length / 2; i < length / 2 + 6; i++) {
                System.out.print((char) out.get(i));
            }
        }
    }
}
