public class MaxScore{
    public static void main(String[] args) {
        System.out.print(maxScore("010"));
        System.out.print(maxScore("1111"));


    }


    public static int maxScore(String s) {
        int init=0;
        int max=0;
        for (int i = 0; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if(c=='0'){
                init++;
            }
        }
        char end=s.charAt(s.length()-1);
        if(end=='1'){
            init++;
        }
        max=init;
        for (int i = s.length()-2; i >=1; i--) {
            char c = s.charAt(i);
            if(c=='1'){
                init++;
            }else{
                init--;
            }
            if(max<init){
                max=init;
            }
        }
            return max;
    }

}