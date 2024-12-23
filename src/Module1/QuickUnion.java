package Module1;

import java.util.Arrays;

public class QuickUnion {
    static int[]  numbers = {0, 1, 2, 8, 3, 5, 5, 7, 8, 9};
    public static void main(String[] args) {
        union(9,4);
        union(2,1);
        System.out.println(comprobate(9,4));
        System.out.println(comprobate(4,9));
        System.out.println(comprobate(0,8));
    }

    public static void union(int number1, int number2){

        numbers[number1] = getRoot(number2);
        System.out.println(Arrays.toString(numbers));
    }

    public static boolean comprobate(int number1, int number2){
        return getRoot(number1) == getRoot(number2);
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
