import java.util.Stack;
public class HomeworkAssignment1_1 {
    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(13);
        obj.push(12);
        obj.push(1);
        obj.push(-12);
        obj.push(100);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMax());
    }
}
/**
 * The MaxStack program implements a Stack class with the following features:
 * push(x) -- push element x onto stack
 * pop() -- remove the element on top of the stack
 * top() -- get the top element.
 * getMax() -- retrieve the max element in the stack in constant time (i.e., O(1)
 */
class MaxStack {
    Stack<Integer> myStack = new Stack<>();
    Stack<Integer> maxVal = new Stack<>();
    public MaxStack() {
    }
    public void push(int x) {
        if (maxVal.isEmpty() || x >= maxVal.peek()){
            maxVal.push(x);
        }
        myStack.push(x);
    }
    public void pop() {
        if (myStack.empty()){
            System.out.println("Stack is empty");
        } else if(maxVal.peek().equals(myStack.peek())){
            maxVal.pop();
        }
        myStack.pop();
    }
    public int top() {
        if (myStack.empty()){
            System.out.println("Stack is empty");
            return 0;
        }
        return myStack.peek();
    }
    public int getMax() {
        if (myStack.empty()){
            System.out.println("Stack is empty");
            return 0;
        }
        return maxVal.peek();
    }
}