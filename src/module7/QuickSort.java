package module7;

public class QuickSort<Type extends Comparable<Type>> {
    Type[] values;

    public QuickSort(Type[] values) {
        this.values = values;
    }

    public Type[] sort(Type[] values) {
        if(values == null || values.length == 1 ) {
            return values;
        }

        //escogemos el pivote
        Type pivot = values[0];
        //creamos dos nuevos arreglos uno para menores otro para mayores
        Type[] less = new Type[values.length];
    }
}
