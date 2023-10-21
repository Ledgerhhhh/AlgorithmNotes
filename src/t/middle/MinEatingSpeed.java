package t.middle;

public class MinEatingSpeed {

    public static void main(String[] args) {
        int i = minEatingSpeed(new int[]{1000000000,1000000000}, 3);
        System.out.println(i);
    }


    public static int minEatingSpeed(int[] piles, int h) {
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
        if(i!=1){
            i /= 2;
        }
        for (; ; i++) {
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
        return i;
    }


}
