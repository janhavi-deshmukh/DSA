package binarySearch;

import javax.crypto.SealedObject;
import java.util.Arrays;

public class searchInMatrix {
    public static void main(String[] args) {
        int[][] mat={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int target=90;
        System.out.print(Arrays.toString(search(mat,target)));

    }

    public static int[] search(int[][] mat,int target){

        int row=mat.length;
        int col=mat[0].length;

        int colMid=col/2;
        int rowStart=0;
        int rowEnd=mat.length-1;

        if(row==1){
            return binarySearch(mat,0,target,0,mat[0].length-1);
        }

        //run loop till 2 rows remaining
        while(rowStart<(rowEnd-1)){ //this is true till rows are more than 2

            int mid=rowStart+(rowEnd-rowStart)/2;
            if(mat[mid][colMid]==target){
                return new int[]{mid,colMid};
            }
            else if(mat[mid][colMid]<target){
                rowStart=mid;
            }
            else{
                rowEnd=mid;
            }
        }

        //check if target is in col of 2 rows
        if(mat[rowStart][colMid]==target){
            return new int[]{rowStart,colMid};
        }
        if(mat[rowStart+1][colMid]==target){
            return new int[]{rowStart+1,colMid};
        }

        //search in 1st
        if(target<=mat[rowStart][colMid-1]){
            return binarySearch(mat,rowStart,target,0,colMid-1);

        }
        //search in 2nd
        if(target>=mat[rowStart][colMid+1] && target<=mat[rowStart][col-1]){
            return binarySearch(mat,rowStart,target,colMid+1,col-1);

        }
        //search in 3rd half
        if(target<=mat[rowStart+1][colMid-1]){
            return binarySearch(mat,rowStart,target,0,colMid-1);
        }
        else{
            return binarySearch(mat,rowStart+1,target,colMid+1,col-1);
        }



    }

    public static int[] binarySearch(int[][] mat,int row,int target,int cstart,int cend){

        while(cstart<=cend){
            int mid=cstart+(cend-cstart)/2;
            if(mat[row][mid]==target){
                return new int[]{row,mid};
            }
            if(mat[row][mid]>target){
                cend=mid-1;
            }
            else{
                cstart=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

}
