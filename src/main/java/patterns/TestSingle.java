package patterns;

public class TestSingle {
    public static void main(String[] args) {
        Single<String> ss = new Single<>("hello");
        System.out.println(ss.get());
        try {
            Single<String> ss2 = new Single<>("world");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
