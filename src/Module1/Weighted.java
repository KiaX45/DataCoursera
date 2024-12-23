package Module1;

import java.util.Arrays;
import java.util.HashMap;

public class Weighted {

    static int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static HashMap<Integer, Integer> weights = new HashMap<>();

    public static void main(String[] args) {
        union(4, 3);
        union(8, 3);
        union(9, 4);
        union(6, 5);
        union(5,0);
        union(2,1);
        union(7,2);
        union(6,1);
        union(7,3);
    }

    public static void union(int number1, int number2) {
        int root1 = getRoot(number1);
        int root2 = getRoot(number2);
        int weight1 = (weights.getOrDefault(root1, 1));
        int weight2 = (weights.getOrDefault(root2, 1));

        if(weight1 >= weight2){
            numbers[root2] = root1;
            weights.put(root1, weight1 + weight2);
        }

        if(weight1 < weight2) {
            numbers[root1] = root2;
            weights.put(root2, weight1 + weight2);
        }

        System.out.println(Arrays.toString(numbers));


    }

    public static int getRoot(int number){
        int root = numbers[number];
        if(root != number){
            return getRoot(root);
        }else{
            return root;
        }
    }


}
