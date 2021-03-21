package strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreadAnalyzer {
    static String threadData =
            "58.27.82.161@08/10/2015\n" +
                    "204.45.234.40@08/11/2015\n" +
                    "58.27.82.161@08/11/2015\n" +
                    "58.27.82.161@08/12/2015\n" +
                    "58.27.82.161@08/12/2015\n" +
                    "[Next log section with different data format]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threadData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
                "(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s%n", date, ip);
        }
    }
}
