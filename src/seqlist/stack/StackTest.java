package seqlist.stack;

public class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
