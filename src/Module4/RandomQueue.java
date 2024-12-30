package Module4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class RandomQueue<Type> implements Iterable<Type> {

    List<Type> queue = new ArrayList<Type>();

    //atributos
    Random random = new Random();

    //Metodos

    public int enqueue(Type value) {
        if( value == null){
            throw new IllegalArgumentException();
        }
        queue.add(value);
        return queue.size() - 1;
    }

    public Type dequeue() {
        comprobation();
        int randomIndex = this.random.nextInt(queue.size());
        return queue.remove(randomIndex);
    }

    public Type sample(){
        comprobation();
        return queue.get(this.random.nextInt(queue.size()));
    }

    private void comprobation(){
        if(queue.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
    }


    @Override
    public Iterator<Type> iterator() {
        return new Iterator<Type>() {
            final List<Type> randomList = new ArrayList<>(queue);
            @Override
            public boolean hasNext() {
                return !randomList.isEmpty();
            }

            @Override
            public Type next() {
                if(!hasNext()){
                    throw new java.util.NoSuchElementException();
                }
                int index = random.nextInt(randomList.size());
                Type value = randomList.get(index);
                randomList.remove(index);
                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public void printQueue(){
        for (Type value : this){
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
