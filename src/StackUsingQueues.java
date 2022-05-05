import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }

    Queue<Integer> queue;

    int topMost = -1;

    public StackUsingQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        topMost = x;
    }

    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        while (queue.size() > 1) {
            topMost = queue.remove();
            q2.add(topMost);
        }

        int ele = queue.remove();
        queue = q2;
        return ele;
    }

    public int top() {
        return topMost;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}