import java.util.Stack;
public class HomeworkAssignment2_1 {
    public static void main(String[] args) {
        // just like any problems, whatever you need here, etc.
        int [] pushed1 = {1, 2, 3, 4};
        int [] popped1 = {3, 2, 1, 4};
        int [] pushed2 = {1, 2, 3, 4};
        int [] popped2 = {3, 4, 2, 1};
        int [] pushed3 = {2, 1, 3};
        int [] popped3 = {3, 2, 1};
        int [] pushed4 = {1, 2, 3};
        int [] popped4 = {1, 2, 3};
        int [] pushed5 = {1};
        int [] popped5 = {1};
        Solution test = new Solution();
        System.out.println(test.isSameEventSequence(pushed1, popped1)); //true
        System.out.println(test.isSameEventSequence(pushed2, popped2)); //true
        System.out.println(test.isSameEventSequence(pushed3, popped3)); //false
        System.out.println(test.isSameEventSequence(pushed4, popped4)); //true
        System.out.println(test.isSameEventSequence(pushed5, popped5)); //true
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * isSameEventSequence(int[] events_pushed, int[] events_popped)
     * PURPOSE:
     * Takes in two integer arrays, representing pushed and popped
     * elements of the Stack,  as arguments and determines if these two
     * arrays are a part of the same event sequence Stack.
     * PARAMETERS:
     * int[] events_pushed, int[] events_popped
     * RETURN VALUE:
     * boolean value, true if both arrays are the same event sequence,
     * false if not.
     **/
    public boolean isSameEventSequence(int[] events_pushed, int[] events_popped) {
        Stack<Integer> myStack = new Stack<>();
        int count = 0;
        for (int i = 0; i < events_pushed.length; i ++) {
            myStack.push(events_pushed[i]);
            while (!myStack.empty() && myStack.peek().equals(events_popped[count])) {
                myStack.pop();
                count++;
            }
        }
        return myStack.empty();
    }
}
