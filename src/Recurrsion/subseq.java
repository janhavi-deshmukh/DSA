package Recurrsion;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subseq {

    public static void main(String[] args) {

        //subsequence("","abc");
        //System.out.print(subsequeceReturn("","abc"));

//        int[] arr={1,2,3};
//        List<List<Integer>> ans=subsetIteration(arr);
//        for(List<Integer> num: ans){
//            System.out.println(num);
//        }

        int[] arr={1,2,2};
        List<List<Integer>> ans=subsetIterationDuplicate(arr);
        for(List<Integer> num: ans){
            System.out.println(num);
        }
    }

    public static void subsequence(String p, String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);
        subsequence(p+ch,up.substring(1));
        subsequence(p,up.substring(1));

    }

    public static ArrayList<String> subsequeceReturn(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch=up.charAt(0);

        ArrayList<String> left=subsequeceReturn(p+ch,up.substring(1));
        ArrayList<String> right=subsequeceReturn(p,up.substring(1));

        left.addAll(right);

        return left;
    }

    public static List<List<Integer>> subsetIteration(int[] arr){

        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:arr){

            int n=outer.size();
            for(int j=0;j<n;j++){
                List<Integer> inner=new ArrayList<Integer>(outer.get(j));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }

    public static List<List<Integer>> subsetIterationDuplicate(int[] arr){

        Arrays.sort(arr);
        //maintain start and end , and if duplicate start with br from end+1

        int start=0;
        int end=0;


        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            start=0;

            //if current and previous element is same, update start
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end=outer.size()-1;

            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer> inner=new ArrayList<Integer>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        return outer;
    }


}
