public class smallerNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] ans=new int[nums.length];
        int[] count=new int[101];

        //store the frequecy of each element
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }

        //now check if each element is greater than others
        int start=0;
        while(start!=nums.length-1){

            for(int j=0;j<nums.length;j++){

                if(nums[start]>nums[j])
                {
                    ans[start]+=count[nums[j]];
                }
            }
        }




        return ans;
    }
}
