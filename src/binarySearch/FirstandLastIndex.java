package binarySearch;

import java.util.Arrays;

public class FirstandLastIndex {
    public static void main(String[] args) {
        int[] nums={5,5,7,7,7,7,8,8,10};
        int target=7;
        int[] ans=new int[2];
        ans[0]=search(nums,target,true);
        ans[1]=search(nums,target,false);

        System.out.print(Arrays.toString(ans));
    }

    public static int search(int[] nums,int target,boolean firstIndex){

        int start=0;
        int end=nums.length-1;
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(target<nums[mid])
            {
                end=mid-1;
            }
            else if(target>nums[mid])
            {
                start=mid+1;
            }
            else{
                ans=mid;

                if(firstIndex){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }

      }
        return ans;

 }
}
