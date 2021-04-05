import java.util.Stack;
public class HomeworkAssignment4_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test cases:
        System.out.println(sol.postfix("4 55 + 62 23 - *")); //2301
        System.out.println(sol.postfix("5 2 4 * + 7 -")); //6
        System.out.println(sol.postfix("5 7 + 6 2 -     *")); //48
        System.out.println(sol.postfix("-1 2 +")); //1
        System.out.println(sol.postfix("-1               2               +")); //1
        System.out.println(sol.postfix("1 2 3 * + 4 +")); //11
        System.out.println(sol.postfix("8 5 * 7 4 2 + * +")); //82
        System.out.println(sol.postfix("6 8 2 / 1 - *")); //18
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * public int postfix(String equation)
     * PURPOSE:
     * Takes in a String, representing the arithmetic
     * expressions in which the operators appear after their operands,
     * performs the operations and returns a result (int).
     * PARAMETERS:
     * String equation
     * RETURN VALUE:
     * int the result of the calculation
     **/
    public int postfix(String equation) {
        int result;
        Stack<Integer> myStack = new Stack<>();
        String arr[] = equation.split("\\s+");
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals("*")){
                result = myStack.pop() * myStack.pop();
                myStack.push(result);
            } else if (arr[i].equals("/")){
                int arg2 = myStack.pop();
                int arg1 = myStack.pop();
                result = arg1 / arg2;
                myStack.push(result);
            }else if (arr[i].equals("-")){
                int arg2 = myStack.pop();
                int arg1 = myStack.pop();
                result = arg1 - arg2;
                myStack.push(result);
            }else if (arr[i].equals("+")){
                result = myStack.pop() + myStack.pop();
                myStack.push(result);
            } else {
                myStack.push(Integer.parseInt(arr[i]));
            }
        }
        return myStack.peek();
    }
}