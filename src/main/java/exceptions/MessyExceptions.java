package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MessyExceptions {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src/main/java/exceptions/MessyExceptions.java"));
            int contents = in.read();
            // Process contents
        } catch (IOException e) {
            // Handle the error
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // Handle the close error
                }
            }
        }
    }
}
