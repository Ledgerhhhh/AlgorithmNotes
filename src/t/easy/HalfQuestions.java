package t.easy;

import java.util.Arrays;

public class HalfQuestions {
    public int halfQuestions(int[] questions) {
        int[] arr = new int[1001];
        for (int question : questions) {
            arr[question]++;
        }
        Arrays.sort(arr);
        int personCount = questions.length / 2;
        int k = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            personCount -= arr[i];
            k++;
            if (personCount <= 0) {
                break;
            }
        }
        return k;
    }
}
