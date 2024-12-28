package Module4;

public class Stack {

    private class Node {
        int value;
        Node next;
    }

    //atributos
    private Node top = null;

    public boolean empty(){
        return top == null;
    }

    public boolean push(int value) {
        if(empty()){
            top = new Node();
            top.value = value;
            top.next = null;
            return true;
        } else{
            Node next = new Node();
            next.value = value;
            next.next = top;
            top = next;
            return true;
        }
    }

    public int pop(){
        if(empty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            int value = top.value;
            top = top.next;
            return value;
        }
    }
}
