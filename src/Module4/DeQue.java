package Module4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DeQue<Type> implements Iterable<Type> {

    private static class Node<Type> {
        Type value;
        Node<Type> next;
        Node<Type> prev;
    }

    //Creamos dos punteros una para que apunte al mas reciente y otro al mas antiguo
    private Node<Type> last = null;
    private Node<Type> first = null;
    private int size = 0;

    //Metodos get


    public Type getLast() {
        return last.value;
    }

    public Type getFirst() {
        return first.value;
    }

    public int getSize() {
        return size;
    }

    //Metodos para saber si la Deque es vacia
    public boolean empty() {
        return size == 0;
    }

    //Metodos para añadir elementos
    public void addFirst(Type value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        size++;
        Node<Type> newNode = new Node<Type>();
        newNode.value = value;
        newNode.prev = null;
        if (last == null) {
            newNode.next = null;
            last = newNode;
            first = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    public void addLast(Type value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        size++;
        Node<Type> newNode = new Node<Type>();
        newNode.value = value;
        newNode.next = null;
        if (first == null) {
            newNode.prev = null;
            first = newNode;
        }
        if (last != null) {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
    }


    //metodos para eliminar Nodos
    public Type removeFirst() {
        if (empty()) {
            throw new NoSuchElementException();
        }

        Type value = first.value;
        if(first == last) {
            reset();
            return value;
        }
        first = first.next;
        first.prev = null;
        size--;
        return value;
    }

    public Type removeLast() {
        if (empty()) {
            throw new NoSuchElementException();
        }

        Type value = last.value;
        if(first == last) {
            reset();
            return value;
        }

        last = last.prev;
        last.next = null;
        size--;
        return value;
    }

    private void reset() {
        last = null;
        first = null;
        size = 0;
    }

    //Metodo Iterator
    @Override
    public Iterator<Type> iterator() {
        return new Iterator<Type>() {
            Node<Type> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Type next() {
                Type value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    public void printDeque() {
        for (Type value : this) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}
