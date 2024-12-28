package Module3;

import java.util.Arrays;

public class BinarySearch {

    static int[] numeros = {6,13,14,25,33,43,51,53,64,72,84,93,95,96};

    public static void main(String[] args) {
            binarySearch(numeros, 34);
    }

    public static boolean binarySearch(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
       int mid_length = (int) nums.length / 2;

       if(nums.length <= 1){
           System.out.println("Target Not found");
           return false;
       }

       if(nums[mid_length] == target){
           System.out.println("Target found");
           return true;
       } else if (nums[mid_length] > target) {
            return binarySearch(Arrays.copyOfRange(nums, 0, mid_length), target);
       } else {
           return binarySearch(Arrays.copyOfRange(nums, mid_length, nums.length), target);
       }
    }

}
