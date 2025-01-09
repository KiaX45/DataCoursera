package Module6;

import java.util.Arrays;

public class MergeSort<Type extends Comparable<Type>> {

    //atributos
    Type[] values = null;

    public MergeSort(Type[] values) {
        this.values = values;
    }

    public Type[] sort() {
        int middle = values.length / 2;
        return mergeSort(Arrays.copyOfRange(values, 0, middle), Arrays.copyOfRange(values, middle, values.length));
    }

    private Type[] mergeSort(Type[] values1, Type[] values2) {
        System.out.println("values 1" + Arrays.toString(values1));
        System.out.println("values 2" + Arrays.toString(values2));
        System.out.println("--------------------------------------");

        //comprobamos si estan ordenados las mitades
        if(values1.length != 1 && !comprobate(values1) ){
            values1 = mergeSort(Arrays.copyOfRange(values1, 0, values1.length/2), Arrays.copyOfRange(values1, values1.length/2, values1.length));
        }

        if(values2.length != 1 && !comprobate(values2)){
            values2 = mergeSort(Arrays.copyOfRange(values2, 0, values2.length/2), Arrays.copyOfRange(values2, values2.length / 2, values2.length));
        }

        return merge(values1, values2);
    }

    private Type[] merge(Type[] values1, Type[] values2) {
        Type[] finalValues = Arrays.copyOf(values1, values1.length + values2.length);
        //Necesitamos tres punteros uno al inicio del final y lo otros dos al inicio de cada uno de los arreglos
        int indexValues1 = 0;
        int indexValues2 = 0;
        for (int i = 0; i < finalValues.length; i++) {
            //si ha llegado al final simplemente que vaya tomando lo numeros del otro
            if(indexValues2 >= values2.length){
                finalValues[i] = values1[indexValues1];
                indexValues1++;
                continue;
            }

            if(indexValues1 >= values1.length){
                finalValues[i] = values2[indexValues2];
                indexValues2++;
                continue;
            }

            if(values1[indexValues1].compareTo(values2[indexValues2]) <= 0 ){
                finalValues[i] = values1[indexValues1];
                indexValues1++;
            }else{
                finalValues[i] = values2[indexValues2];
                indexValues2 ++;
            }
        }
        return finalValues;
    }

    public boolean comprobate(Type[] values) {
        //System.out.println(Arrays.toString(values));
        for (int i = 1; i < values.length; i++) {
            if(values[i].compareTo(values[i-1]) < 0){
                return false;
            }
        }
        return true;
    }

}
