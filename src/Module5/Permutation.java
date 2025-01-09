package Module5;

import java.util.HashMap;

public class Permutation<Type extends Comparable<Type>> {
    //attributes
    Type[] array1 = null;
    Type[] array2 = null;
    HashMap<Type, Boolean> numbersSeen = new HashMap<>();

    public Permutation(Type[] array1, Type[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    public boolean comprobate(){
        //ordenamos los dos arreglos primeramente
        sort(array1);
        sort(array2);
        //recorremos el primero normalmente
        int index2 = 0;
        for (int i = 0; i < array1.length; i++) {
            //comprobamos si el numero en index i esta en el hashmap

            if(!numbersSeen.getOrDefault(array1[i], false)){
                //si no hemos visto el valor primero comprobamos si es igual al del segundo arreglo
                if(array1[i].compareTo(array2[index2]) == 0){
                    //si son iguales los aumentamos en el hashmap
                    numbersSeen.put(array1[i], true);
                }else{
                    //si son diferentes tenemos que mantenernos en el mismo index en el primer arreglo y vamos avanzando en el segundo
                    //retornamos false bajo dos condiciones
                    // 1. si el numero que encontramos es mayor al que tenemos actualmente
                    // 2. si el segundo index ya llego al final del segundo arreglo
                    if(index2 == array2.length-1){
                        return false;
                    }
                    while(index2 < array2.length-1){
                        index2++;
                        if(array2[index2].compareTo(array1[i]) > 0){
                            return false;
                        }

                        if(array2[index2].compareTo(array1[i]) == 0){
                            //en caso de que encontremos el numero igual lo adicionamos y rompemos el ciclo
                            numbersSeen.put(array1[i], true);
                            break;
                        }
                    }
                }
            }

        }
        return true;

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
