package t.easy;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CountPoints {

    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }

    public static int countPoints(String rings) {
        HashMap<Integer, int[]> integerHashMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            integerHashMap.put(i, new int[3]);
        }

        for (int i = 1; i < rings.length(); i += 2) {
            int[] ints = integerHashMap.get(Integer.valueOf(rings.charAt(i) + ""));
            char c = rings.charAt(i - 1);
            if (c == 'R') {
                ints[0]++;
            } else if (c == 'G') {
                ints[1]++;
            } else if (c == 'B') {
                ints[2]++;
            }
        }
        int yb = 0;
        for (Map.Entry<Integer, int[]> integerEntry : integerHashMap.entrySet()) {
            int[] v = integerEntry.getValue();
            if (v[0] != 0 && v[1] != 0 && v[2] != 0) {
                yb++;
            }
        }
        return yb;


    }


}
