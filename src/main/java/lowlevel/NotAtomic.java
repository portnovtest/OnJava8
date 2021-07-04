package lowlevel;

// javap -c NotAtomic
// {ExcludeFromGradle}
// {VisuallyInspectOutput}

public class NotAtomic {
    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}
