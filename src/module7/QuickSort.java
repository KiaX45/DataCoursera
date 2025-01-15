package module7;

public class QuickSort<Type extends Comparable<Type>> {
    Type[] values;

    public QuickSort(Type[] values) {
        this.values = values;
    }

    public void quickSort() {
       printValues( sort(values, 0, values.length - 1));
    }

    private Type[] sort(Type[] values, int inicio, int final_) {
        if (inicio >= final_) {
            return values; // Caso base
        }

        // Partición del arreglo
        Object[] result = partition(values, inicio, final_);
        Type[] newValues = (Type[]) result[0];
        int indexPivot = (int) result[1];

        // Ordenar recursivamente las dos mitades
        newValues = sort(newValues, inicio, indexPivot - 1); // Lado izquierdo
        newValues = sort(newValues, indexPivot + 1, final_); // Lado derecho
        return newValues;
    }

    private Object[] partition(Type[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Type pivot = a[lo];

        while (true) {
            while (less(a[++i], pivot)) {
                if (i == hi) break; // Encuentra el primer elemento mayor o igual al pivote
            }
            while (less(pivot, a[--j])) {
                if (j == lo) break; // Encuentra el primer elemento menor o igual al pivote
            }
            if (i >= j) break; // Si los índices se cruzan, terminamos
            swap(a, i, j); // Intercambiar los elementos encontrados
        }
        swap(a, lo, j); // Colocar el pivote en su posición final
        return new Object[]{a, j}; // Retorna el arreglo y el índice del pivote
    }

    private boolean less(Type v, Type w) {
        return v.compareTo(w) < 0; // Utiliza compareTo para comparar los valores
    }

    private void swap(Type[] values, int indexI, int indexJ) {
        Type temp = values[indexI];
        values[indexI] = values[indexJ];
        values[indexJ] = temp;
    }


    private void printValues(Type[] values) {
        for(Type value : values) {
            System.out.print(value + " -> ");
        }
        System.out.println();
    }
}
