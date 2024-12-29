package Module4;

public class test {
    public static void main(String[] args) {

    testDeque();

    }

    private static void testDeque(){
        DeQue<Integer> deQue = new DeQue<>();
        deQue.addLast(3);
        deQue.addLast(2);
        deQue.addLast(1);
        deQue.printDeque();

    }


    private static void testQueue () {
        Queue2Stack<Integer> queue = new Queue2Stack<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueueEntrada();
        queue.printQueueSalida();
        System.out.println(queue.dequeue());
        queue.printQueueEntrada();
        queue.printQueueSalida();
    }

    private static void testStack () {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Stack<String> nombres =  new Stack<String>();
        nombres.push("Luis");
    }
}
