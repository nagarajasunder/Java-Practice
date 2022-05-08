import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class DinnerPlatesImpl {
    private final List<Stack<Integer>> stackList = new ArrayList<>();
    private int currentEmptyStackIndex;
    private int currentStackCapacity;
    private final int stackCapacity;
    private int rightNonEmptyStackIndex;
    private final List<Integer> stackPopList = new ArrayList<>();

    public DinnerPlatesImpl(int capacity) {
        Stack<Integer> new_stack = new Stack<>();
        currentEmptyStackIndex = 0;
        currentStackCapacity = 0;
        stackCapacity = capacity;
        stackList.add(new_stack);
        rightNonEmptyStackIndex = 0;
    }

    public void push(int val) {
        System.out.println("Push " + val);
        if (currentStackCapacity < stackCapacity) {
            stackList.get(currentEmptyStackIndex).push(val);
            currentStackCapacity++;
            if (currentStackCapacity == stackCapacity && currentEmptyStackIndex == stackList.size() - 1) {
                Stack<Integer> new_stack = new Stack<>();
                stackList.add(new_stack);
                currentEmptyStackIndex = stackList.size() - 1;
                rightNonEmptyStackIndex = stackList.size() - 1;
                currentStackCapacity = 0;
            }

        } else {
            int index = getLeftMostNonEmptyStack();
            if (index == -1) {
                Stack<Integer> new_stack = new Stack<>();
                new_stack.push(val);
                currentStackCapacity = new_stack.size();
                stackList.add(new_stack);
                currentEmptyStackIndex = stackList.size() - 1;
                rightNonEmptyStackIndex = stackList.size() - 1;
            } else {
                stackList.get(index).push(val);
                currentEmptyStackIndex = index;
                currentStackCapacity = stackList.get(index).size();
            }

        }

    }

    private int getLeftMostNonEmptyStack() {
        for (int i = currentEmptyStackIndex; i < stackList.size(); i++) {
            if (stackList.get(i).isEmpty() || stackList.get(i).size() < stackCapacity) {
                return i;
            }
        }
        return -1;
    }

    public int pop() {
        System.out.println("Pop");
        if (currentEmptyStackIndex == stackList.size() - 1 && !stackList.get(currentEmptyStackIndex).isEmpty()) {
            currentStackCapacity--;
            return stackList.get(currentEmptyStackIndex).pop();
        } else {
            int index = getRightMostNonEmptyStack();
            if (index == -1) {
                return -1;
            } else {
                currentEmptyStackIndex = index;
                currentStackCapacity = stackList.get(index).size() - 1;
                return stackList.get(index).pop();
            }
        }
    }

    public int popAtStack(int index) {
        System.out.println("Pop At Stack " + index);
        if (index < stackList.size()) {
            var stackAtIndex = stackList.get(index);
            if (!stackAtIndex.isEmpty()) {
                if (index < currentEmptyStackIndex) {
                    currentEmptyStackIndex = index;
                    currentStackCapacity = stackAtIndex.size() - 1;
                } else if (index > rightNonEmptyStackIndex) {
                    rightNonEmptyStackIndex = index;
                }
                return stackAtIndex.pop();
            } else {
                return -1;
            }
        }

        return -1;
    }

    private int getRightMostNonEmptyStack() {

        int len = stackList.size() - 1;
        for (int i = len; i >= 0; i--) {
            if (!stackList.get(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    public void printStacks() {
        for (Stack<Integer> integers : stackList) {
            System.out.println(integers);
        }
        System.out.println("=========================================================");
    }

    public void getSystemData() {
        System.out.println("Current Empty Stack Index " + currentEmptyStackIndex);
        System.out.println("Current Stack Capacity " + currentStackCapacity);
        System.out.println("Stack List Size " + stackList.size());
        System.out.println("Stack Pop List " + stackPopList);
        System.out.println("============================================================");
    }
}

public class DinnerPlates {
    public static void main(String[] args) {

        DinnerPlatesImpl D = new DinnerPlatesImpl(2);
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);
        D.popAtStack(0);
        D.printStacks();
        D.getSystemData();
        D.push(20);
        D.push(21);
    }
}