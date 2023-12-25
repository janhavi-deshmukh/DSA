package binarySearch;

public class MountainPeak {
    public static void main(String[] args) {
        int[] nums={0,2,4,10,2,3,0};
        System.out.print(findPeak(nums));
    }

    public static int findPeak(int[] nums){
        int start=0;
        int end=nums.length-1;

        while(start<end){
             int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                end=mid;
            }
            if(nums[mid]<nums[mid+1]){
                start=mid+1;
            }
        }
        return nums[start];
    }
}
