package Module5;

import java.util.Arrays;
import java.util.Random;

public class Shuffle<Integer> {
    //atributos
    Integer[] cartas = null;

    public Shuffle(Integer[] cartas) {
        this.cartas = cartas;
    }

    public void shuffle(){
        Random randomNumbers = new Random();
        for (int i = 1; i < this.cartas.length; i++) {
            int randomIndex = randomNumbers.nextInt(i);
            if(randomIndex != i){
                swap(i,randomIndex);
            }
        }
    }

    public void swap(int index1, int index2){
        Integer temp = this.cartas[index1];
        this.cartas[index1] = this.cartas[index2];
        this.cartas[index2] = temp;
    }

    public void print(){
        System.out.println(Arrays.toString(this.cartas));
    }


}
