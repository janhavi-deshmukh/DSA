package Recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {

    public static void main(String[] args) {

        dice("",3);
        List<String> a=dicereturn("",3);
        System.out.println(a);
    }

    public static void dice(String p, int target){

        if(target==0){
            System.out.println(p);
            return;
        }

        for(int i=1;i<=6 && i<=target;i++){

            dice(p+i,target-i);
        }
    }

    public static List<String> dicereturn(String p,int target){

        if(target==0){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();
        for(int i=1;i<=6 && i<=target;i++){

            ans.addAll(dicereturn(p+i,target-i));
        }
        return ans;
    }

    public static List<String> diceFacereturn(String p,int target,int face){

        if(target==0){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();
        for(int i=1;i<=face && i<=target;i++){

            ans.addAll(diceFacereturn(p+i,target-i,face));
        }
        return ans;
    }


}
