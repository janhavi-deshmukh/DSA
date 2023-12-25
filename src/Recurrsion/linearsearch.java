package Recurrsion;

import java.util.ArrayList;

public class linearsearch {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,4,5};
        System.out.print(findAll(arr,4,0));

    }

    //search withput passing arraylist in argument
    private static ArrayList<Integer> findAll(int[] arr,int target,int index){

        ArrayList<Integer> list=new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }

        ArrayList<Integer> ansfrombelow=findAll(arr,target,index+1);

        list.addAll(ansfrombelow);

        return list;
    }
}
