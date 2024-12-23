package Module1;

import java.util.Arrays;

public class QuickSearch {

    static int[]  numbers = {1, 2, 3, 4, 5, 6 ,7 ,8, 9, 10};

    public static void main(String[] args) {
            union(4,3);
            union(3,8);
            union(5,6);
            union(9,4);
            union(2,1);
    }

    public static void union (int number1, int number2){
        int connect = numbers[number2];
        int search = numbers[number1];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == search){
                numbers[i] = connect;
            }
        }
        System.out.println(Arrays.toString(numbers));

    }

    public static boolean connected(int number1, int number2){
        return numbers[number1] == numbers[number2];
    }
}
