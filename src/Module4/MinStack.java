package Module4;

class MinStack {

    //clase interna
    private static class Node<Type> {
        Type value = null;
        Node next = null;
    }

    //atributes
    Node<Integer> head = null;
    Integer minValue = null;
    MinStack secondStack = null;

    public MinStack() {
        secondStack = new MinStack(true);

    }

    public MinStack(boolean value){

    }

    public void push (int val) {
        secondPush(val);
        if( minValue == null || val <= minValue ) {
            minValue = val;
            System.out.println(minValue);
            //como encontramos un valor menor lo vamos a poner en la segunda stack para poderlo recordar
            secondStack.secondPush(head.value);
        }
    }

    public void secondPush (int val) {
        Node<Integer> newNode = new Node<Integer>();
        newNode.value = val;
        newNode.next = head;
        head = newNode;

    }

    public void pop() {
        if(head == null){
            System.out.println("the stack is alredy empty");
        }

        if(head.value.equals(minValue)){

            //como estamos elminando el valor minimo tenemos que eliminar el mismo valor pero de la segunda pila
            secondStack.secondPop();
            //actualizamos el valor del minimo al ultimo valor de la second stack
            try {
                minValue = secondStack.top();
            }catch (Exception e){
                minValue = null;
            }

        }

        secondPop();
    }

    public void secondPop () {
        head = head.next;
    }

    public int top() {
        if(head == null) throw new NullPointerException();
        return head.value;

    }

    public int getMin() {
        if(head == null) throw new NullPointerException();
        return minValue;
    }
}