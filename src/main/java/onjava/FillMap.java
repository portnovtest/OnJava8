package onjava;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FillMap {
    public static <K, V> Map<K, V> basic(Supplier<Pair<K, V>> pairGen, int size) {
        return Stream.generate(pairGen)
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value));
    }

    public static <K, V> Map<K, V> basic(Supplier<K> keyGen, Supplier<V> valueGen, int size) {
        return Stream.generate(
                () -> Pair.make(keyGen.get(), valueGen.get()))
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value));
    }

    public static <K, V, M extends Map<K, V>> M create(Supplier<K> keyGen, Supplier<V> valueGen, Supplier<M> mapSupplier, int size) {
        return Stream.generate(
                () -> Pair.make(keyGen.get(), valueGen.get()))
                .limit(size)
                .collect(Collectors.toMap(Pair::key, Pair::value, (k, v) -> k, mapSupplier));
    }
}
