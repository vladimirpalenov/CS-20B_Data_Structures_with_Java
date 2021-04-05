import java.util.Stack;
public class HomeworkAssignment5_1 {
    public static void main(String[] args) {
        // TEST CASE #1
        System.out.println("Test case 1");
        Solution sol = new Solution();
        sol.add(8);
        sol.add(1);
        System.out.println(sol.peek());     // 8 (if you use System.out.println(), for example)
        System.out.println(sol.remove());   // 8
        System.out.println(sol.isEmpty());  // false
        System.out.println(sol.remove());   // 1
        System.out.println(sol.isEmpty());  // true
        sol.add(2);
        sol.add(3);
        System.out.println(sol.peek());     // 2
        // TEST CASE #2
        System.out.println("Test case 2");
        Solution sol1 = new Solution();
        sol1.add(8);
        sol1.add(1);
        sol1.remove();
        System.out.println(sol1.peek());     // 1 (if you use System.out.println(), for example)
        System.out.println(sol1.remove());   // 1
        System.out.println(sol1.isEmpty());  // true
        sol1.add(100);
        System.out.println(sol1.isEmpty());  // false
        sol1.add(2);
        sol1.add(3);
        System.out.println(sol1.peek());     // 100
    }
}
class Solution {

    // YOUR STACK TO USE FOR THIS PROBLEM
    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> popStack = new Stack<Integer>();

    /**
     * MEMBER FUNCTION NAME:
     * public void add(int x)
     * PURPOSE:
     * Implements a queue add function, inserts the specified x element
     * to the back of queue without violating capacity limitation
     * PARAMETERS:
     * int x
     * RETURN VALUE:
     * void
     **/
   public void add(int x) {
       pushStack.push(x);
   }
    /**
     * MEMBER FUNCTION NAME:
     * public int remove()
     * PURPOSE:
     * Implements a queue remove function, removes the head (front) of queue,
     * returning the removed element.
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * int - the removed element's value
     **/
   public int remove() {
       if (popStack.empty()) {
           while (!pushStack.empty()) {
               popStack.push(pushStack.pop());
           }
       }
       return popStack.pop();
   }
    /**
     * MEMBER FUNCTION NAME:
     * public int peek()
     * PURPOSE:
     * Implements a queue peek function, etrieves and displays but does
     * not remove (i.e., read-only) the head of queue.
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * int value of the head of the queue.
     **/
   public int peek() {
       if (popStack.empty()) {
           while (!pushStack.empty()) {
               popStack.push(pushStack.pop());
           }
       }
       return popStack.peek();
   }
    /**
     * MEMBER FUNCTION NAME:
     * public boolean isEmpty()
     * PURPOSE:
     * Implements a queue isEmpty function, returns whether the queue is empty or
     * not as boolean.
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * boolean value - true if the queue is empty, false if it's not.
     **/
   public boolean isEmpty() { 
     if (popStack.empty() && pushStack.empty()) {
         return true;
     } else {
         return false;
     }
   }
}