package Module1;

import java.util.HashMap;

public class Sucesor {

    //Contiene el numero:Sucesor para eliminar el numero simplemente cambiamos el sucesor
    //para que tenga el numero inmediatamente mayor
    static HashMap<Integer, Integer> numbers = new HashMap<>();

    public static void main(String[] args) {
        build(10);
        System.out.println(next(2));
        remove(2);
        remove(3);
        System.out.println(next(2));
    }

    public static void build(int size){
        for (int i = 0; i < size; i++) {
            numbers.put(i,i);
        }
    }

    public static void remove(int number){
        //ontenemos el numeros que le sigue si es null pues sabemos que el numero a remover es el ultimo de la lista
        int next = numbers.getOrDefault(number + 1,-1);
        if(next != -1){
            //si es diferente de -1 sabemos que no es el ultimo por lo que por lo que reemplazamos el valor actual por el siguiente
            numbers.put(number,next(next));
        }else {
            //en caso de que es el ultimo ponemos un numero negativo como -1
            numbers.remove(number);
        }

    }

    public static int next(int number){
        //obtenemos el valor
        int next = numbers.getOrDefault(number,-1);
        //System.out.println(next);

        //en caso de que sea -1 significa que no hay siguiente
        if(next == -1){
            System.out.println("no hay numero siguiente");
            return next;
        }

        if(next == number) return number; //porque el valor aun no se ha removido
        //de lo contrario buscamos el otro valor de forma que vamos aplanando
        next = next(next);
        numbers.put(number,next);
        return next;
    }

}
