import java.util.Stack;
public class HomeworkAssignment1_2 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-13);
        obj.push(12);
        obj.push(1);
        obj.push(-12);
        obj.push(100);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
/**
 * The MinStack program implements a Stack class with the following features:
 * push(x) -- push element x onto stack
 * pop() -- remove the element on top of the stack
 * top() -- get the top element.
 * getMin() -- retrieve the min element in the stack in constant time (i.e., O(1)
 */
class MinStack {
    Stack<Integer> myStack = new Stack<>();
    Stack<Integer> minVal = new Stack<>();
    public MinStack() {
    }
    public void push(int x) {
        if (minVal.isEmpty() || x <= minVal.peek()){
            minVal.push(x);
        }
        myStack.push(x);
    }
    public void pop() {
        if (myStack.empty()){
            System.out.println("Stack is empty");
        } else if(minVal.peek().equals(myStack.peek())){
            minVal.pop();
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
    public int getMin() {
        if (myStack.empty()){
            System.out.println("Stack is empty");
            return 0;
        }
        return minVal.peek();
    }
}
