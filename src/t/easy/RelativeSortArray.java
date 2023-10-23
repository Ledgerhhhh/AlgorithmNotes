package t.easy;

import java.util.*;

public class RelativeSortArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        for (int j : arr2) {
            linkedHashMap.put(j, 0);
        }

        int p = 0;

        int[] ints2 = new int[arr1.length];

        for (int v : arr1) {
            Integer init = linkedHashMap.get(v);
            if (init != null) {
                linkedHashMap.put(v, init + 1);
            } else {
                ints2[p] = v;
                p++;
            }
        }

        int[] ints = new int[arr1.length];
        int pointer = 0;

        for (Map.Entry<Integer, Integer> integerIntegerEntry : linkedHashMap.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            for (int i = 0; i < value; i++) {
                ints[pointer] = key;
                pointer++;
            }
        }
        Arrays.sort(ints2);

        System.arraycopy(ints2, ints2.length - p, ints, ints.length - p, p);

        return ints;


    }
}
