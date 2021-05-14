package generics;

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        //- s1.set(sbs);
        // error: method set in interface SelfBoundSetter<T> cannot be applied to given types;
        //  s1.set(sbs);
        //     ^
        // required: Setter
        // found: SelfBoundSetter
        // reason: argument mismatch;
        // SelfBoundSetter cannot be converted to Setter where T is a type-variable:
        //  T extends SelfBoundSetter<T> declared in
        //  interface SelfBoundSetter
        // 1 error
    }
}
