package arrays;

import onjava.Count;

import java.util.Arrays;

import static onjava.ArrayShow.show;

public class ParallelPrefix1 {
    public static void main(String[] args) {
        int[] nums = new Count.Pint().array(10);
        show(nums);
        System.out.println(Arrays.stream(nums)
                .reduce(Integer::sum)
                .getAsInt());
        Arrays.parallelPrefix(nums, Integer::sum);
        show(nums);
        System.out.println(Arrays.stream(new Count.Pint().array(6))
                .reduce(Integer::sum)
                .getAsInt());
    }
}
