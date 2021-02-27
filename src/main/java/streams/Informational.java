package streams;

public class Informational {
    public static void main(String[] args) throws Exception {
        System.out.println(FileToWords.stream("src/main/java/streams/Cheese.dat").count());
        System.out.println(FileToWords.stream("src/main/java/streams/Cheese.dat")
                .min(String.CASE_INSENSITIVE_ORDER)
                .orElse("NONE"));
        System.out.println(FileToWords.stream("src/main/java/streams/Cheese.dat")
                .max(String.CASE_INSENSITIVE_ORDER)
                .orElse("NONE"));
    }
}
