package Module3;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static HashMap<Integer, Integer> numbers = new HashMap<>();

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{-1, 0, 1, 2, -1, -4}, 8);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], nums[i]);
            Integer result = numbers.getOrDefault(target - nums[i], null);
            if (result != null){
                return new int[]{nums[i], result};
            }
        }

        return new int[]{};
    }
}
