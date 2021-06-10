package standardio;

// How to read from standard input

import onjava.TimedAbort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Echo {
    public static void main(String[] args) {
        TimedAbort abort = new TimedAbort(2);
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .peek(ln -> abort.restart())
                .forEach(System.out::println);
        // Ctrl-Z or two seconds of inactivity terminates the programd
    }
}
