package Recurrsion;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {

        //permutations("","abc");
//        ArrayList<String> ans=permutationreturn("","abc");
//        System.out.println(ans);

        System.out.println(permutationCount("","ab"));
    }

    public static void permutations(String p,String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        //recursive function will be called size of p+1 times
        for(int i=0;i<=p.length();i++){

            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            char ch=up.charAt(0);
            permutations(first+ch+second,up.substring(1));
        }
    }

    public static ArrayList<String> permutationreturn(String p,String up){

        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++){

            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            char ch=up.charAt(0);
            ans.addAll(permutationreturn(first+ch+second,up.substring(1)));
        }
        return ans;

    }

    public static int permutationCount(String p,String up){

        if(up.isEmpty()){
            return 1;
        }

        int count=0;
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++){

            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            char ch=up.charAt(0);
            count=count+permutationCount(first+ch+second,up.substring(1));
        }
        return count;

    }
}
