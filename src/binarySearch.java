public class binarySearch {
    public static void main(String[] args) {
        int[] nums={1,4,5,8,10,15};
        int target=15;
//        System.out.print(binarysearch(nums,target));
        System.out.print(recursiveBS(nums,target,0,nums.length-1));

    }

    static int binarysearch(int[] arr,int target){

        int start=0;
        int end=arr.length-1;


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

    static int recursiveBS(int[] arr,int target,int start,int end){

        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;

        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]<target){
            return recursiveBS(arr,target,mid+1,end);
        }

        return recursiveBS(arr,target,start,mid-1);

    }
}
