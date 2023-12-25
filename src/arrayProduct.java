import java.util.Arrays;

public class arrayProduct {

    public static int[] productExceptSelf(int[] nums) {

        int[] product = new int[nums.length];
        int mult=1;
        //prefix
        for(int i=0;i<nums.length;i++){
            product[i]=mult;
            mult+=nums[i];
        }

        mult=1;
        //suffix
        for(int i=nums.length-1;i>=0;i--){
            product[i]=mult;
            mult*=nums[i];
        }

        return product;

    }

    public static void main(String[] args){

        int[] nums= new int[]{2, 1, 3, 4};
        System.out.print(Arrays.toString(productExceptSelf(nums)));
    }
}
