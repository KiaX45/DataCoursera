package Module6;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        testRandomLinkedList();

    }

    public static void testRandomLinkedList(){
        RandomLinkedList<Integer> randomLinkedList = new RandomLinkedList<>(new Integer[]{1,2,3,4,5});
        randomLinkedList.print(randomLinkedList.showRandomValues());
        randomLinkedList.sort();
    }

    public static void testMergeSort(){
        MergeSort<Integer> mergeSort = new MergeSort<>(new Integer[]{5,3,1,7,8,9,3,1});
        Integer[] finalResult = mergeSort.sort();
        System.out.println(Arrays.toString(finalResult));
    }

}


