package main.test;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();


        for (int i = 10; i >=0; i--) {
            integerIntegerTreeMap.put(i,1);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : integerIntegerTreeMap.entrySet()) {
            System.out.println(integerIntegerEntry.getKey());
        }

    }
}
