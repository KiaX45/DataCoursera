package Module5;

public class SelectionSort<Type extends Comparable<Type>>  { //de esa forma decimos que puede tenet cualquier tipo que implemente la interfaz comparable
    Type[] arreglo;
    public SelectionSort(Type[] arreglo) {
        this.arreglo = arreglo;
    }

    public void sort() {
        for (int i = 0; i < arreglo.length - 1; i++) {
            int tempMin = i;

            for (int j = i + 1; j < arreglo.length; j++) {
                if(less(arreglo[j], arreglo[tempMin])) {
                    tempMin = j;

                }
            }
            if(tempMin != i){
                exchange(arreglo, i, tempMin);
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
