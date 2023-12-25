package binarySearch;
public class ceilingNumber {
    private static int getceilingNumber(int[] nums, int target) {

        //if the number target is greater than greatest number in array
        //then not found
        if(target>nums[nums.length-1]){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {


            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return nums[mid];

            }
            else if (target > nums[mid]) {
                start = mid + 1;
            }
            else if(target<nums[mid]) {
                end = mid - 1;
            }


        }

        return nums[start];


    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9, 14, 16, 18};
        int target = 20;
        System.out.print(getceilingNumber(nums, target));

    }

}


