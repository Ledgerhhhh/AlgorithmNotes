package t.easy;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {

    public static void main(String[] args) {
        List<List<Integer>> aaa = largeGroupPositions("abbxxxxzzy");
        System.out.println(aaa);
    }


    public static List<List<Integer>> largeGroupPositions(String s) {
        ArrayList<List<Integer>> arrayLists = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i >= 1) {
                if (c == s.charAt(i - 1)) {
                    k++;
                } else {
                    if (k >= 2) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(i - k-1);
                        integers.add(i-1);
                        arrayLists.add(integers);
                    }
                    k = 0;
                }
            }
        }
        if (k >= 2) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(s.length() - 1 - k);
            integers.add(s.length() - 1);
            arrayLists.add(integers);
        }
        return arrayLists;
    }

}
