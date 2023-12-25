package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class Phonepad {

    public static void main(String[] args) {

        //phonepad("","12");
        System.out.println(phoneletter("","12"));
    }

    public static void phonepad(String p, String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        //to convert ascii char value to int number
        int digit=up.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++){

            //to get ascii value
            char ch=(char)('a'+i);
            phonepad(p+ch,up.substring(1));
        }
    }

    public static List<String> phoneletter(String p, String up){

        if(up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();

        int digit=up.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++){

            char ch=(char)('a'+i);
            ans.addAll(phoneletter(p+ch,up.substring(1)));
        }
        return ans;
    }
}
