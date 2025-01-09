package Module5;

import java.util.Arrays;

public class Intersection<Type extends Comparable<Type>> {
    //attributes
    Type[] array1 = null;
    Type[] array2 = null;

    public Intersection(Type[] array1, Type[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    public void intercept(){
        //ordenamos los dos arreglos primeramente
        sort(array1);
        sort(array2);
        //recorremos el primero normalmente
        int index2 = 0;
        for (int i = 0; i < array1.length; i++) {
            if(array1[i].compareTo(array2[index2])==0){
                System.out.println(array1[i]+" == "+array2[index2]);
                index2++;
            }
            if(array1[i].compareTo(array2[index2])>0){
                index2++;
                i--;
            }

        }

    }

    private void sort(Type[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--){
                if(less(array[j], array[j-1])){
                    swap(array, j, j-1);
                }else{
                    break;
                }
            }

        }
    }

    private boolean less(Type a, Type b){
        return a.compareTo(b) < 0;
    }

    private void swap(Type[]array, int index1, int index2){
        Type temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
