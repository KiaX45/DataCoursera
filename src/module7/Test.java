package module7;

public class Test {
    public static void main(String[] args) {
        testQuickSort();
    }
    public static void testQuickSort(){
        QuickSort<Integer> quickSort = new QuickSort<>(new Integer[]{1,2,5,3,10,8,10});
        quickSort.quickSort();
    }
}
