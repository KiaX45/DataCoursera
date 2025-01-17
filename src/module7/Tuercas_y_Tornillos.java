package module7;

public class Tuercas_y_Tornillos<Type extends Comparable<Type>> {

    //atributos
    private Type[] tuercas = null;
    private Type[] tornillos = null;

    public Tuercas_y_Tornillos(Type[] tuercas, Type[] tornillos) {
        this.tuercas = tuercas;
        this.tornillos = tornillos;
    }

    public void sort() {
        patiticionate(this.tuercas, tornillos[0], 0, this.tuercas.length - 1);
    }

    private Type patiticionate(Type[] values, Type pivot, Integer inicio, Integer final_) {
        //solo conocemos como las valores de la tuercas se relacionan con el pivote
        //hay tres posibles opciones < = >
        int menores = inicio;
        while (final_ - 1 != inicio && inicio < final_) {
            System.out.println(menores);
            System.out.println(inicio);
            System.out.println(final_);
            //aqui viene lo bueno con iguales hay que recordar una cosa la condición de salida es
            //que no puede estar inicio a lado de mayor

            //si inicio es igual pero final es menor significa que tenemos que poner final antes que inicio
            if (values[inicio].compareTo(pivot) == 0 && values[final_].compareTo(pivot) < 0) {
                //intercambiamos con el siguiete
                swap(values, menores, menores + 1);
                //intercambiamos ahora con el que cambiamos con final
                swap(values, menores, final_);
                //avanzamos
                if(menores == inicio){
                    inicio++;
                }
                menores++;
            }

            //si inicio es mayor y final es igual reemplazamos
            if (values[inicio].compareTo(pivot) > 0 && values[final_].compareTo(pivot) == 0) {
                swap(values, inicio, final_);
                final_--;
            }

            //si inicio y mayor soy iguales
            if(values[inicio].compareTo(pivot) == 0 && values[final_].compareTo(pivot) == 0) {
                swap(values, inicio, inicio + 1);
                swap(values, inicio, final_);
                inicio++;
            }

            //esta es la mas facil si inicio es menor avanzamos
            if (values[inicio].compareTo(pivot) < 0) {
                inicio++;
                menores++;
            }

            //otra facil si el elemento en final es mayor avanzamos
            if (values[final_].compareTo(pivot) > 0) {
                final_--;
            }

            //si final es menor que inicio reemplazamos
            if (values[menores].compareTo(pivot) < 0 && values[inicio].compareTo(pivot) > 0) {
                swap(values, menores, final_);
                menores++;
            }



            printValues(values);

        }

        System.out.println(menores);
        System.out.println(inicio);
        System.out.println(final_);

        //ahora si ultima comprobación si tenemos un =< pero puede ser ====<
        if (values[inicio].compareTo(pivot) == 0 && values[final_].compareTo(pivot) < 0) {
            swap(values, menores, final_);
            menores++;
        }

        printValues(values);

        return values[inicio];


    }

    private void swap(Type[] values, int index1, int index2) {
        Type tmp = values[index1];
        values[index1] = values[index2];
        values[index2] = tmp;
    }

    //metodos auxiliares
    public void printValues(Type[] values) {
        for (Type value : values) {
            System.out.print(value + " -> ");
        }
        System.out.print("null");
        System.out.println();

    }


}
