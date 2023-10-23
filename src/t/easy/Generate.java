package t.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate {

    public static void main(String[] args) {
        Generate generate = new Generate();

        System.out.println(generate.generate(3));
    }

    public List<List<Integer>> generate(int numRows) {
        // TODO 杨辉
        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);
        ArrayList<List<Integer>> integers1 = new ArrayList<>();
        if (numRows == 1) {
            integers1.add(integers);
            return integers1;
        }
        integers1.add(new ArrayList<>(integers));
        int size = integers.size();
        for (int i = 0; i < numRows - integers.size()+1; i++) {
            integers.add(0);
        }
        for (int i = numRows - size; i >= 1; i--) {
            integers.set(i, integers.get(i) + integers.get(i - 1));
            integers1.add(new ArrayList<>(integers));
        }

        return integers1;
    }
}
