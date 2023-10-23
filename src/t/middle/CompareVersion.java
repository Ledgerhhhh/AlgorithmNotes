package t.middle;


public class CompareVersion{

    public static void main(String[] args) {
        System.out.println(8008);
    }

    public int compareVersion(String version1, String version2) {
        String[] vs1= version1.split("\\.");
        String[] vs2= version1.split("\\.");
        ArrayList<String> v1 = new ArrayList<>(Arrays.asList(vs1));
        ArrayList<String> v2 = new ArrayList<>(Arrays.asList(vs2));

        if(v1.size<3){
            v1.add("0");
        }
        if(v2.size<3){
            v2.add("0");
        }

        for(int i;i<3;i++){
            int i1=Integer.valueOf();
            int i2=Integer.valueOf();
            if(){

            }
        }




        return 0;
    }

}