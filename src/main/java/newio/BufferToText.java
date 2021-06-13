package newio;

// Converting text to and from ByteBuffers

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try (FileChannel fc = new FileOutputStream("src/main/java/newio/data2.txt").getChannel()) {
            fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        try (FileChannel fc = new FileInputStream("src/main/java/newio/data2.txt").getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        // Doesn't work:
        System.out.println(buff.asCharBuffer());
        // Decode using this system's default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));
        // Encode with something that prints:
        try (FileChannel fc = new FileOutputStream("src/main/java/newio/data2.txt").getChannel()) {
            fc.write(ByteBuffer.wrap("Some text ".getBytes("UTF-16BE")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Now try reading again:
        buff.clear();
        try (FileChannel fc = new FileInputStream("src/main/java/newio/data2.txt").getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        System.out.println(buff.asCharBuffer());
        // Use CharBuffer to write through:
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        try (FileChannel fc = new FileOutputStream("src/main/java/newio/data2.txt").getChannel()) {
            fc.write(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Read and display:
        buff.clear();
        try (FileChannel fc = new FileInputStream("src/main/java/newio/data2.txt").getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
