package module7;

public class Test {
    public static void main(String[] args) {
        testTuercas();
    }

    public static void testTuercas(){
        Tuercas_y_Tornillos<Integer> tuercas_y_tornillos = new Tuercas_y_Tornillos<>(new Integer[]{2, 5, 2, 4, 7}, new Integer[]{5,1,9,7,5});
        tuercas_y_tornillos.sort();
    }

    public static void testQuickSort(){
        QuickSort<Integer> quickSort = new QuickSort<>(new Integer[]{1,2,5,3,10,8,10});
        quickSort.quickSort();
    }
}
