package Module4;

public class test {
    public static void main(String[] args) {
        testUnix();
    }


    public static void testUnix(){
        Unix unix = new Unix();
        System.out.println(unix.simplifyPath("/home/user/Documents/../Pictures"));
    }


    public static  void testPolishNotation(){
        PolishNotation polishNotation = new PolishNotation();
        System.out.println(polishNotation.evalRPN(new String[]{"2","1","+","3","*"}));
    }


    public static void testMinStack(){
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        System.out.println("---------------------");
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
    }


    private static void testRandomQueue(){
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        randomQueue.dequeue();
        randomQueue.printQueue();
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
