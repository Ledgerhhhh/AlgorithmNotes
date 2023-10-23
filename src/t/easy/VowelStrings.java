package t.easy;

public class VowelStrings {


    public int vowelStrings(String[] words, int left, int right) {
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        int i = 0;

        for (int j = left; j <= right; j++) {
            String word = words[j];
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);
            if(contain(chars,start) && contain(chars,end)){
                i++;
            }
        }
        return i;
    }

    static boolean contain(char[] chars,char c){
        for (char aChar : chars) {
            if(c==aChar) return true;
        }
        return false;
    }
}
