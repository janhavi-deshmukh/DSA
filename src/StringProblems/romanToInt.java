package StringProblems;
import java.io.*;
import java.util.*;
import java.util.HashMap;
public class romanToInt {
    public static int convert(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(char w:s.toCharArray()){
            if(w=='I') map.put(w,1);
            if(w=='V') map.put(w,5);
            if(w=='X') map.put(w,10);
            if(w=='L') map.put(w,50);
            if(w=='C') map.put(w,100);
            if(w=='D') map.put(w,500);
            if(w=='M') map.put(w,1000);
        }

        int j=0;
        int[] values=new int[s.length()];
        for(char c:s.toCharArray()){
            values[j]=map.get(c);
            j++;
        }

        System.out.println(Arrays.toString(values));
        int result=0;
        for(int i=values.length-1;i>=0;i--){
            if(i>0 && values[i]>values[i-1]){
                result+=values[i]-values[i-1];
                i--;
            }else{
                result+=values[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        String s ="MCMXCIV";
        System.out.print(convert(s));
    }
}
