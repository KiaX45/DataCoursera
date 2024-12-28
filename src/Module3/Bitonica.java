package Module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bitonica {

    public static void main(String[] args) {
       // List<Integer> list = new ArrayList<>(Arrays.asList(16,15,14,12,10,8,6,4,1,0));
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 2, 7, 5, 3, 1));
        //System.out.println(list.subList(3, list.size()));
        System.out.println(getBitonica(list, 5));

        //System.out.println(getPico(list, 0, list.size()));

        //System.out.println(binarySearchInverse(list, 0, 0, list.size()));
    }

    public static int getBitonica(List<Integer> list, int target) {
        //obtenemos el index del pico
        int indexPico = getPico(list, 0, list.size());
        //partimos el arreglo en dos y mandamos la que esta a la izquierda del pico osea la que esta creciente a
        //ordenarse por medio del binario y la otra a la de inversa


        //primero la creciente
        List<Integer> creciente = list.subList(0, indexPico + 1);
        List<Integer> decreciente = list.subList(indexPico + 1, list.size());
        int result = binarySearch(creciente, target, 0, creciente.size());

        if(result == -1){
            //comprobamos en la decreciente
            result = binarySearchInverse(decreciente, target, 0, decreciente.size());
            return result + creciente.size();
        }

        return result;
    }

    public static int getPico (List<Integer> numbers, int min, int max) {
        // Calcular el índice medio
        int mid = (max - min) / 2 + min;

        if(numbers.get(mid - 1) < numbers.get(mid) &&  numbers.get(mid + 1) < numbers.get(mid)) {
            //encontramos el pico
            return mid;
        }
        //System.out.println(numbers.get(mid));
        if(numbers.get(mid) < numbers.get(mid+1)) {
            //es creciente por lo tanto el pico debe estan a la derecha
            return getPico(numbers, mid, max);
        } else {
            return getPico(numbers, min, mid);
        }

    }


    public static int binarySearch(List<Integer> numbers, int target, int min, int max) {
        // Condición base: si los índices se cruzan, el elemento no está en la lista
        if (min > max) {
            return -1;
        }
        // Calcular el índice medio
        int mid = (max - min) / 2 + min;
        // Comprobar si el elemento medio es el target
        if (numbers.get(mid) == target) {
            return mid;
        }
        // Ajustar el rango dependiendo de la posición del target
        if (target < numbers.get(mid)) {
            return binarySearch(numbers, target, min, mid - 1); // Buscar en la mitad izquierda
        } else {
            return binarySearch(numbers, target, mid + 1, max); // Buscar en la mitad derecha
        }
    }


    public static int binarySearchInverse(List<Integer> numbers, int target, int min, int max) {
        // Condición base: si los índices se cruzan, el elemento no está en la lista
        if (min > max) {
            return -1;
        }
        // Calcular el índice medio
        int mid = (max - min) / 2 + min;
        // Comprobar si el elemento medio es el target
        if (numbers.get(mid) == target) {
            return mid;
        }
        // Ajustar el rango dependiendo de la posición del target
        if (target > numbers.get(mid)) {
            return binarySearchInverse(numbers, target, min, mid - 1); // Buscar en la mitad izquierda
        } else {
            return binarySearchInverse(numbers, target, mid + 1, max); // Buscar en la mitad derecha
        }
    }



}
