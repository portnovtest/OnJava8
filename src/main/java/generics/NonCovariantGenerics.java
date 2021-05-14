package generics;

// {WillNotCompile}

public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    // List<Fruit> flist = new ArrayList<>(Apple);
}
