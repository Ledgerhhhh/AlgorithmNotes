package t.middle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareVersion {

    public static void main(String[] args) {
//        System.out.println(compareVersion("1.01", "1.001"));
//        System.out.println(compareVersion("1.0", "1.0.0"));
//        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        ArrayList<String> v1 = new ArrayList<>(Arrays.asList(vs1));
        ArrayList<String> v2 = new ArrayList<>(Arrays.asList(vs2));
        int n1 = vs1.length;
        int n2 = vs2.length;
        int max = Math.max(n1, n2);
        if (n1 < max) {
            for (int i = 0; i < max - n1; i++) {
                v1.add("0");
            }
        }
        if (n2 < max) {
            for (int i = 0; i < max - n2; i++) {
                v2.add("0");
            }
        }

        for (int i = 0; i < max; i++) {
            int i1 = Integer.parseInt(v1.get(i));
            int i2 = Integer.parseInt(v2.get(i));
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            }
        }
        return 0;
    }

}