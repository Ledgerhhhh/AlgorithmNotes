package t.easy;

import java.util.Arrays;

public class BestHand {

    public static void main(String[] args) {
        System.out.println(bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
        System.out.println(bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'}));
        System.out.println(bestHand(new int[]{10, 10, 2, 12, 9}, new char[]{'a', 'b', 'c', 'a', 'd'}));
    }

    public static String bestHand(int[] ranks, char[] suits) {

        boolean b = checkSome(suits);
        if (b) {
            return evaluateHand(999);
        }
        return evaluateHand(getSomeNum(ranks));
    }

    public static int getSomeNum(int[] ranks) {
        Arrays.sort(ranks);
        int maxNum = 1;
        int cur = 1;
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] == ranks[i - 1]) {
                cur++;
            } else {
                maxNum = Math.max(maxNum, cur);
                cur = 1;
            }
        }
        maxNum = Math.max(maxNum, cur);
        return maxNum;


    }

    public static boolean checkSome(char[] suits) {
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                return false;
            }
        }
        return true;
    }

    public static String evaluateHand(int handValue) {
        switch (handValue) {
            case 999:
                return "Flush";
            case 4:
            case 3:
                return "Three of a Kind";
            case 2:
                return "Pair";
            case 1:
                return "High Card";
            default:
                return "";
        }
    }

}
