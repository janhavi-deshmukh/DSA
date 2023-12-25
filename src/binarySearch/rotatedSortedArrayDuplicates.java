package binarySearch;

public class rotatedSortedArrayDuplicates {

    public static void main(String[] args) {
        int[] nums={3,1,2,3,3,3,3};
        int target=0;
        System.out.print(search(nums,target));
    }

    public static boolean search(int[] nums,int target){

        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(target==nums[mid]){
                return true;
            }
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start++;
                end--;
                continue;
            }
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && target<=nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return false;

    }
}
