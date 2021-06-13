package newio;

// Copying files using channels and buffers
// {java ChannelCopy ChannelCopy.java src/main/java/newio/test.txt}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        try (FileChannel in = new FileInputStream(args[0]).getChannel();
             FileChannel out = new FileOutputStream(args[1]).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            while (in.read(buffer) != -1) {
                buffer.flip(); // Prepare for writing
                out.write(buffer);
                buffer.clear(); // Prepare for reading
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
