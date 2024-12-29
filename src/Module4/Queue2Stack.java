package Module4;

public class Queue2Stack<Type>  {
    //creamos dos stacks una para la entrada y otra para la salida
    Stack<Type> entrada = new Stack<>();
    Stack<Type> salida = new Stack<>();

    public void enqueue(Type t) {
        entrada.push(t);
    }

    public Object dequeue() {
       salida =  entrada.invertStack();
       Object value = salida.pop();
       entrada = salida.invertStack();
       return value;
    }

    public void printQueueEntrada() {
        entrada.printStack();
    }

    public void printQueueSalida() {
        salida =  entrada.invertStack();
        salida.printStack();
    }




}

