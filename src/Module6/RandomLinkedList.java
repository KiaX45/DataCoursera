package Module6;

import java.util.Iterator;
import java.util.Random;

public class RandomLinkedList<Type extends Comparable<Type>> implements Iterable<Type> {


    private class Node {
        Type value;
        int randomValue;
        Node next;
    }

    //attributes
    private Node head = new Node();
    int size = 0;

    public RandomLinkedList(Type[] values) {
        size = values.length;
        Random rand = new Random();
        Node current = head;
        for (Type value : values) {
            current.value = value;
            current.randomValue = rand.nextInt(values.length * 10);
            if(value == values[values.length - 1]){
                continue;
            }
            Node newNode = new Node();
            current.next = newNode;
            current = newNode;
        }

    }

    public Type getHead() {
        return head.value;
    }
    //Metodos principales

    public void sort(){
        Node tempNode = breakList(head,size/2);
        this.head = divide(size/2, size - size/2, head, tempNode);
        printValues(this.head);
    }

    private Node divide(Integer size1, Integer size2, Node node1, Node node2) {
        //la idea es que tenemos que llegar al final del arbol basicamente vamos a retornar el resultado cuando
        //size es uno que es la ultima hoja del arbol de decisiones
        if(node1.next != null){
            //significa que aun no llegamos al final por lo que tenemos que seguir recorriendo
            Node tempNode1 = breakList(node1,size1/2);
            printValues(node1);
            printValues(tempNode1);
            node1 =  divide(size1/2, size1 - size1/2, node1, tempNode1);
        }

        if(node2.next != null){
            //System.out.println(size2);
            Node tempNode2 = breakList(node2, size2/2);
            printValues(node2);
            printValues(tempNode2);
            node2 =  divide(size2/2, size2 - size2/2, node2, tempNode2);
        }

        return merge(node1,node2);
    }

    private Node breakList(Node node, Integer end){
        //hay dos posibilidades si no nos dan start es que quieren del incio a un punto
        //de lo contrario es de un punto hasta el final
        int counter = 0;
        Node current = node;
        while(counter < end && end != 1){
            current = current.next;
            counter++;
        }

        //antes de romper la cadena creamos un nuevo puntero que apunte a counter.next y ese lo retornamos
        Node lastNode = current.next;
        current.next = null;
        return lastNode;
    }

    private Node merge(Node node1, Node node2){
        Node finalNode = new Node();
        Node result = finalNode;
        while (node1 != null || node2 != null){

            if(node1 == null){
                finalNode.next = node2;
                finalNode = node2;
                node2 = node2.next;
                continue;
            }

            if(node2 == null){
                finalNode.next = node1;
                finalNode = node1;
                node1 = node1.next;
                continue;
            }

            if(node1.randomValue < node2.randomValue){
                if(finalNode.value == null){
                    finalNode = node1;
                    result = finalNode;
                    node1 = node1.next;
                    continue;
                }
                finalNode.next = node1;
                finalNode = node1;
                node1 = node1.next;
            }else{
                if(finalNode.value == null){
                    finalNode = node2;
                    result = finalNode;
                    node2 = node2.next;
                    continue;
                }

                finalNode.next = node2;
                finalNode = node2;
                node2 = node2.next;
            }
        }

        return result;
    }




    //Metodos auxiliares
    private void printValues(Node node){
        while (node != null) {
            System.out.print(node.value+ " -> ");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }


    @Override
    public Iterator<Type> iterator() {
        return new Iterator<Type>() {
            Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Type next() {
                Type result = current.value;
                current = current.next;
                return result;
            }
        };
    }

    public Iterator<Integer> showRandomValues() {
        return new Iterator<Integer>() {
            Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                Integer result = current.randomValue;
                current = current.next;
                return result;
            }
        };
    }

    public void print(Iterator<Type> iterator){
        while (iterator.hasNext()) {
            Type value = iterator.next();
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
