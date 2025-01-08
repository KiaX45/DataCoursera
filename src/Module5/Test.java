package Module5;

public class Test {
    public static void main(String[] args) {
        testInsertionSort();
    }

    public static void testInsertionSort() {
        InsertionSort<Integer> insertionSort = new InsertionSort<>(new Integer[] {7,10,5,3,8,4,2,9,6});
        insertionSort.sort();
        insertionSort.print();
    }

    public static void testSelectionSort(){
        SelectionSort<Integer> selectionSort = new SelectionSort<>(new Integer[] {6,5,1,5,7,6});
        selectionSort.sort();
        selectionSort.print();
    }
}
