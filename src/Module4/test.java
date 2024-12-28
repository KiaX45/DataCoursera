package Module4;

public class test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
