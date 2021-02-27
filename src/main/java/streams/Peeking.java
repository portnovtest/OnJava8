package streams;

class Peeking {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("src/main/java/streams/Cheese.dat")
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
