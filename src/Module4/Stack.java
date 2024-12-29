package Module4;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {


    private static class Node<T> {
        T value;
        Node<T> next;
    }

    //atributos
    private Node<T> top = null;

    public boolean empty(){
        return top == null;
    }

    public boolean push(T value) {
        if(empty()){
            top = new Node<T>();
            top.value = value;
            top.next = null;
            return true;
        } else{
            Node<T> next = new Node<T>();
            next.value = value;
            next.next = top;
            top = next;
            return true;
        }
    }

    public Object pop(){
        if(empty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            T value = top.value;
            top = top.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = top;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    public void printStack(){
        for (T value : this){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public Stack<T> invertStack(){
        Stack<T> stackInvertida = new Stack<>();
        for (T value : this){
            stackInvertida.push(value);
        }
        return stackInvertida;
    }
}
