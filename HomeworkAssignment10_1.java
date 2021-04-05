import java.util.*;
public class HomeworkAssignment10_1 {
    public static void main(String[] args) {

        // EXAMPLE: max heap; arraylist representation is [5,4,3,2,1]
        //       5
        //       /\
        //      4  3
        //     / \
        //    2   1

        // An ArrayList representation of the above heap. Note there is no max size
        // specified so this list is dynamically resizable.
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,4,3,2,1));

        // Create an instance of solution by passing this list in. Note this solution
        // is basically a heap, using ArrayList as its underlying buffer to store data.
        Solution sol = new Solution(list);

        // Test the operations: enqueue(element) & dequeue(). You may use print() to
        // display your ArrayList instance in String.
        sol.enqueue(6);
        System.out.println(sol.print());      // [6,4,5,2,1,3]
        sol.dequeue();    // [5,4,3,2,1]
        System.out.println(sol.list);
        sol.enqueue(5);
        System.out.println(sol.print());      // [5,4,5,2,1,3]
        // etc.
    }
}


class Solution {

    // INSTANCE VARIABLES
    ArrayList<Integer> list;
    int lastIndex;

    // --------------------------------------------
    // !!!!PLEASE DO NOT MODIFY THIS CONSTRUCTOR!!!
    // --------------------------------------------
    //Constructor
    public Solution(ArrayList<Integer> list){
        this.list = list;
        lastIndex = list.size() - 1;;
    }

    // --------------------------------------------
    // !!!!PLEASE DO NOT MODIFY THIS PRINT METHOD
    // --------------------------------------------
    /**
     * MEMBER FUNCTION NAME:
     * public String print()
     * PURPOSE:
     * Converts array to string
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * String
     **/
    public String print() {
        return Arrays.toString(list.toArray());
    }

    /**
     * MEMBER FUNCTION NAME:
     * public void enqueue(int element)
     * PURPOSE:
     * this method enqueues an integer element into heap.
     * PARAMETERS:
     * int element
     * RETURN VALUE:
     * void
     **/
    public void enqueue(int element) {
        lastIndex++;
        list.add(lastIndex,element);
        reheapUp(element);
    }

    /**
     * MEMBER FUNCTION NAME:
     * public void dequeue()
     * PURPOSE:
     * this method dequeues the highest priority element from heap.
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * void
     **/
    public void dequeue() {
        int toMove;
        toMove = list.remove(lastIndex);
        lastIndex--;
        if (lastIndex != -1){
            reheapDown(toMove);
        }
    }

    /**
     * MEMBER FUNCTION NAME:
     * private void reheapUp(int x)
     * PURPOSE:
     * this method is called by enqueue(element); it shifts the element up the tree to "reheap" it.
     * PARAMETERS:
     * Sint x
     * RETURN VALUE:
     * void
     **/
    private void reheapUp(int x) {
        int hole = lastIndex;
        int parentIndex = (hole - 1) / 2;
        while ((hole > 0) && (list.get(parentIndex) < x)){
            list.set(hole, list.get(parentIndex));
            hole = (hole - 1) / 2;
            parentIndex = (hole - 1) / 2;
        }
        list.set(hole, x);
    }

    /**
     * MEMBER FUNCTION NAME:
     * private void reheapDown(int x)
     * PURPOSE:
     * this method is called by dequeue(); it shifts the element down the tree to "reheap" it.
     * PARAMETERS:
     * int x
     * RETURN VALUE:
     * void
     **/
    private void reheapDown(int x) {
        int hole = 0;
        int next;
        next = newHole(hole, x);
        while (next != hole){
            list.set(hole,list.get(next));
            hole = next;
            next = newHole(hole, x);
        }
        list.set(hole, x);
    }

    /**
     * MEMBER FUNCTION NAME:
     * private int newHole(int hole, int element)
     * PURPOSE:
     * this method the element with children of dequeued element, and returns the index of the biggest
     * one, or returns back the index passed in as an argument if the element is bigger or equal to the
     * children of dequeued element.
     * PARAMETERS:
     * int hole, int element
     * RETURN VALUE:
     * int
     **/
    private int newHole(int hole, int element) {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;
        if (left > lastIndex){
            return hole;
        } else if (left == lastIndex){
            if (element < list.get(left)){
                    return left;
            } else{
                    return hole;
            }
        } else if (element < list.get(left)){
            if (list.get(left) >= list.get(right)){
                return left;
            } else{
                return right;
            }
        } else if (element < list.get(right)){
            if (list.get(right) > list.get(left)){
                return right;
            } else{
                return left;
            }
        } else{
            return hole;
        }
    }
}