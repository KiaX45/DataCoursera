package Module5;

import com.sun.jdi.IntegerType;

public class Flag<Type extends Comparable<Type>> {
    //attributes
    Type[] values = null;
    //vamos a utilizar tres punteros para cada uno de los colores
    //inicio medio final
    private Integer red = null;
    private Integer white = null;
    private Integer blue = null;

    public Flag(Type[] values) {
        this.values = values;
        red = 0;
        white = this.values.length / 2;
        blue = this.values.length - 1;
    }

    public void sort(){


        //recorremos el arreglo normalmente
        for (int i = 0; i < this.values.length; i++) {
            //por cada uno lo vamos a identificar y lo ponemos el index correspondiente
            Integer newIndex = color(this.values[i], i);

            if(!newIndex.equals(i)){
                swap(this.values, i, newIndex);
                //retenemos i
                i--;
            }

        }
    }

    public void print() {}

    private int color (Type value, int index) {
        // 0 = Rojo
        // 1 = Blanco
        // 2 = Azul

        if(value instanceof Integer integerType) {
            return switch (integerType) {
                case 0 -> {
                    //en caso de que ya este ocupaod este espacio por un elmento del color corespondiente avanzamos
                    if (this.values[this.red].equals(0) && this.red != index) {
                        this.red++;
                    }
                    yield this.red;
                }
                case 1 -> {
                    if (this.values[this.white].equals(1) && this.white != index) {
                        this.white++;
                    }
                    yield this.white;

                }
                case 2 -> {
                    if (this.values[this.blue].equals(2) && this.blue != index) {
                        this.blue--;
                    }
                    yield this.blue;
                }
                default -> -1;
            };
        }

        return 1;
    }

    private void swap (Type[] array, int index1, int index2) {
        Type temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
