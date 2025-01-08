package Module5;

public class InsertionSort<Type extends Comparable<Type>> {

    Type[] arreglo = null;

    public InsertionSort(Type[] arreglo) {
        this.arreglo = arreglo;
    }

    public void sort(){
        for (int i = 1; i < arreglo.length; i++) {
            for (int j = i; j > 0; j--) {
                if(less(arreglo[j],arreglo[j-1] )){
                    exchange(arreglo,j,j-1);
                }
            }
        }
    }

    private boolean less(Type v, Type w) {
        try{
            return v.compareTo(w) < 0;
        }catch (Exception e) {
            return true;
        }
    }

    private void exchange(Type[] array , int IndexNumber1, int IndexNumber2) {
        Type temp = array[IndexNumber1];
        array[IndexNumber1] = array[IndexNumber2];
        array[IndexNumber2] = temp;
    }

    public void print(){
        for (Type type : arreglo) {
            System.out.println(type);
        }
    }
}
