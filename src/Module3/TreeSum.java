package Module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TreeSum {
    static HashMap<Integer, Integer> numbers = new HashMap<>();

    public static void main(String[] args) {

        List<Integer> result = twoSum(new int[]{-1, 0, 1, 2, -1, -4}, -2, 3);
        System.out.println(result);

        List<List<Integer>> result2 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result2);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            List<Integer> resultlist = twoSum(nums, target, i);
            if (!resultlist.isEmpty()) {
                List<Integer> mutableList = new ArrayList<>(resultlist);
                mutableList.add(nums[i]);
                response.add(mutableList);
            }
        }
        return response;
    }

    public static List<Integer> twoSum(int[] nums, int target, int exepcionIndex) {
        for (int i = 0; i < nums.length; i++) {
            Integer result = numbers.getOrDefault(target - nums[i], null);
            numbers.put(nums[i], i);
            if (result != null && i != result && i != exepcionIndex) {
                numbers.clear();
                return Arrays.asList(nums[i], nums[result]);
            }
        }
        numbers.clear();
        return new ArrayList<>();
    }
}
