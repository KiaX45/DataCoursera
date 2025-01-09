package Module5;

public class Test {
    public static void main(String[] args) {
       testFlag();
    }

    public static void testFlag() {
        Flag<Integer> flag = new Flag<>(new Integer[] {1,2,1,2,2,0});
        flag.sort();
        flag.print();
    }

    public static void testPermutation() {
        Permutation<Integer> permutation = new Permutation<>(new Integer[] {1,1,2,3,4}, new Integer[] {1,2,5});
        System.out.println(permutation.comprobate());
    }

    public static void testIntersection(){
        Intersection<Integer> intersection = new Intersection<>(new Integer[] {5,4,3,1,7}, new Integer[] {5,2,3,7,8,9,4});
        intersection.intercept();

    }

    public static void testShuffle(){
        Shuffle<Integer> shuffle = new Shuffle<>(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        shuffle.shuffle();
        shuffle.print();
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
