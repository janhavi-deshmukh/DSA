package binarySearch;
//greatest number smaller than or equal to target
public class floor {

    private static int getceilingNumber(int[] nums, int target) {

        if(target<nums[0]){
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

        return nums[end];


    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9, 14, 16, 18};
        int target = 1;
        System.out.print(getceilingNumber(nums, target));

    }
}
