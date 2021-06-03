package patterns;

public class SingletonPattern2 {
    public static void main(String[] args) {
        Single<Double> pi = new Single<>(Double.valueOf(3.14159));
        Double x = pi.get();
        System.out.println(x);
    }
}
