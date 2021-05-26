package annotations;

import onjava.ProcessFiles;

public class DemoProcessFiles {
    public static void main(String[] args) {
        new ProcessFiles(System.out::println, "java").start(args);
    }
}
