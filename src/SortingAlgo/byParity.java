package SortingAlgo;

import java.util.Arrays;

public class byParity {

    public static void main(String[] args) {

        int[] nums={3,1,2,4,5};

        System.out.print(Arrays.toString(sortArrayByParity(nums)));

    }
    public static int[] sortArrayByParity(int[] nums) {

            int j=0;
            for(int i=nums.length-1;i>=0;i--){

                    if(j<i && nums[i]%2==0)
                    {
                        swap(nums,i,j);
                        j++;
                    }
            }
            return nums;
    }

    public static void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
    }

}
