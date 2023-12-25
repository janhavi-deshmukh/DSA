package binarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] nums={2,3,5,9,14,16,18,21,23,24,30};
        int target=21;

        System.out.print(ans(nums,target));

    }

    public static int ans(int[] nums,int target){
        int start=0;
        int end=1;

        while(target>nums[end]){
            int temp=end+1;
            end=end+(end-start)+1*2;
            start=temp;
        }

        return binarysearch(nums,target,start,end);
    }

    public static int binarysearch(int[] arr,int target,int start,int end){

        while(start<=end){
            int mid=start+(end-start)/2;


            if(arr[mid]==target){
                return mid;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
