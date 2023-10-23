package t.easy;

public class CountSeniors {
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
    }
    public static int countSeniors(String[] details) {
        int res=0;
        for (String detail : details) {
            String ageStr = detail.substring(detail.length() - 4, detail.length() - 2);

            int i = Integer.parseInt(ageStr);
            if(i>60) res++;
        }
        return res;
    }
}
