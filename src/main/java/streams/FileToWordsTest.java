package streams;

public class FileToWordsTest {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("src/main/java/streams/Cheese.dat")
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        System.out.println();
        FileToWords.stream("src/main/java/streams/Cheese.dat")
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}
