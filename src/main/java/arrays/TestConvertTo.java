package arrays;

import onjava.Rand;

import java.util.Arrays;

import static onjava.ArrayShow.show;
import static onjava.ConvertTo.boxed;
import static onjava.ConvertTo.primitive;

public class TestConvertTo {
    static final int SIZE = 6;

    public static void main(String[] args) {
        Boolean[] a1 = new Boolean[SIZE];
        Arrays.setAll(a1, new Rand.Boolean()::get);
        boolean[] a1p = primitive(a1);
        show("a1p", a1p);
        Boolean[] a1b = boxed(a1p);
        show("a1b", a1b);


        Byte[] a2 = new Byte[SIZE];
        Arrays.setAll(a2, new Rand.Byte()::get);
        byte[] a2p = primitive(a2);
        show("a2p", a2p);
        Byte[] a2b = boxed(a2p);
        show("a2b", a2b);

        Character[] a3 = new Character[SIZE];
        Arrays.setAll(a3, new Rand.Character()::get);
        char[] a3p = primitive(a3);
        show("a3p", a3p);
        Character[] a3b = boxed(a3p);
        show("a3b", a3b);

        Short[] a4 = new Short[SIZE];
        Arrays.setAll(a4, new Rand.Short()::get);
        short[] a4p = primitive(a4);
        show("a4p", a4p);
        Short[] a4b = boxed(a4p);
        show("a4b", a4b);

        Integer[] a5 = new Integer[SIZE];
        Arrays.setAll(a5, new Rand.Integer()::get);
        int[] a5p = primitive(a5);
        show("a5p", a5p);
        Integer[] a5b = boxed(a5p);
        show("a5b", a5b);

        Long[] a6 = new Long[SIZE];
        Arrays.setAll(a6, new Rand.Long()::get);
        long[] a6p = primitive(a6);
        show("a6p", a6p);
        Long[] a6b = boxed(a6p);
        show("a6b", a6b);

        Float[] a7 = new Float[SIZE];
        Arrays.setAll(a7, new Rand.Float()::get);
        float[] a7p = primitive(a7);
        show("a7p", a7p);
        Float[] a7b = boxed(a7p);
        show("a7b", a7b);

        Double[] a8 = new Double[SIZE];
        Arrays.setAll(a8, new Rand.Double()::get);
        double[] a8p = primitive(a8);
        show("a8p", a8p);
        Double[] a8b = boxed(a8p);
        show("a8b", a8b);
    }
}
