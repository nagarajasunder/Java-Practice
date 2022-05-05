import java.util.ArrayList;
import java.util.Stack;

public class QueueFromStack {

    public static void main(String[] args) {

        var queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

class MyQueue {

    Stack<Integer> stack;
    int top = -1;
    int last = -1;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        last = x;
        if (top == -1) {
            top = x;
        }
    }

    public int pop() {

        var list = new ArrayList<Integer>();
        while (stack.size() > 1) {
            list.add(0, stack.pop());
        }
        last = stack.pop();
        stack.addAll(list);
        if(list.size() > 0)
        {
            top = list.get(0);
        }
        else
        {
            top = -1;
        }
        return last;
    }

    public int peek() {
        return top;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
