package t.middle;

public class MinEatingSpeed {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed2(new int[]{1000000000, 1000000000}, 3));
        System.out.println(minEatingSpeed2(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed2(new int[]{30,11,23,4,20}, 5));
        System.out.println(minEatingSpeed2(new int[]{30,11,23,4,20}, 6));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int h2 = 0;
        int i = 1;

        for (; ; i *= 2) {
            for (int pile : piles) {
                int k = pile / i;
                if (pile % i != 0) {
                    k++;
                }
                h2 += k;
                if (h2 < 0 || h2 > h) {
                    break;
                }
            }
            if (h2 <= h) {
                break;
            }
            h2 = 0;
        }
        if (i != 1) {
            i >>= 1;
        }


        return 0;
    }


    public static int minEatingSpeed2(int[] piles, int h) {
        int h2 = 0;
        int i = 1;

        for (; ; i *= 2) {
            for (int pile : piles) {
                int k = pile / i;
                if (pile % i != 0) {
                    k++;
                }
                h2 += k;
                if (h2 > h) {
                    break;
                }
            }
            if (h2 <= h) {
                break;
            }
            h2 = 0;
        }
        if (i != 1) {
            i >>= 1;
        }
        int start = i;
        int end = i << 1;
        int max = end;
        while (start <= end) {
            int m = start + end >> 1;
            h2 = 0;
            for (int pile : piles) {
                int k = pile / m;
                if (pile % m != 0) {
                    k++;
                }
                h2 += k;
                if (h2 > h) {
                    start = m + 1;
                    break;
                }
            }
            if (h2 <= h) {
                end = m - 1;
            }
            if (max == m) {
                return m;
            }
        }
        return start;
    }
}
