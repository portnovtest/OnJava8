package collectiontopics;

// Very basic test of Deques

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

class CountString implements Supplier<String> {
    private int n = 0;

    CountString() {

    }

    CountString(int start) {
        n = start;
    }

    @Override
    public String get() {
        return Integer.toString(n++);
    }
}

public class SimpleDeques {
    static void test(Deque<String> deque) {
        CountString s1 = new CountString(),
                s2 = new CountString(20);
        for (int n = 0; n < 8; n++) {
            deque.offerFirst(s1.get());
            deque.offerLast(s2.get()); // Same as offer()
        }
        System.out.println(deque);
        String result = "";
        while (deque.size() > 0) {
            System.out.print(deque.peekFirst() + " ");
            result += deque.pollFirst() + " ";
            System.out.print(deque.peekLast() + " ");
            result += deque.pollLast() + " ";
        }
        System.out.println("\n" + result);
    }

    public static void main(String[] args) {
        int count = 10;
        System.out.println("LinkedList");
        test(new LinkedList<>());
        System.out.println("ArrayDeque");
        test(new ArrayDeque<>());
        System.out.println("LinkedBlockingDeque");
        test(new LinkedBlockingDeque<>(count));
        System.out.println("ConcurrentLinkedDeque");
        test(new ConcurrentLinkedDeque<>());
    }
}
