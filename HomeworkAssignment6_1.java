public class HomeworkAssignment6_1 {
    public static void main(String[] args) {
        // TEST CASE #1: Create a queue with capacity = 1
        System.out.println("Test case #1");
        Solution sol = new Solution(1);
        System.out.println(sol.getFront()); // -1
        System.out.println(sol.getRear());  // -1
        sol.add(8);
        System.out.println(sol.getFront()); // 0
        System.out.println(sol.getRear());  // 0
        System.out.println(sol.peek());     // 8
        System.out.println(sol.remove());   // 8
        System.out.println(sol.isEmpty());  // true
        System.out.println(sol.getFront()); // -1, when queue is empty
        System.out.println(sol.getRear());  // -1, when queue is empty

        // TEST CASE #2: Create a queue with capacity = 3
        System.out.println("Test case #2");
        Solution sol1 = new Solution(3);
        sol1.add(1);
        sol1.add(2);
        sol1.add(3);
        System.out.println(sol1.getFront()); // 0
        System.out.println(sol1.getRear());  // 2
        System.out.println(sol1.remove());   // 1
        System.out.println(sol1.getFront()); // 1
        System.out.println(sol1.getRear());  // 2
        System.out.println(sol1.remove());   // 2
        System.out.println(sol1.getFront());  // 2
        System.out.println(sol1.remove());   // 3
        System.out.println(sol1.isEmpty());  // true
        sol1.add(100);
        System.out.println(sol1.peek());     // 100
        System.out.println(sol1.getFront()); // 0
        System.out.println(sol1.getRear());  // 0
        sol1.add(0);
        System.out.println(sol1.getRear());  // 1
    }
}
class Solution {

    // Dynamic array size
    private int capacity;
    // Queue
    private int[] elements;
    // Dynamic queue size
    private int numElements = 0;
    // Dynamic index for the front of queue, defaulting to -1
    private int front       = -1;
    // Dynamic index for the rear of queue, defaulting to -1
    private int rear       = -1;

    // Constructor
    public Solution(int capacity) {
        this.capacity = capacity;
        this.elements = new int[this.capacity];
    }
    // Get the front index
    public int getFront() {
        return this.front;
    }
    // Get the rear index
    public int getRear() {
        return this.rear;
    }

   // =====================================
   //  !!! DO NOT MODIFY ABOVE THIS LINE!!!
   // ====================================

    /**
     * MEMBER FUNCTION NAME:
     * public void add(int x)
     * PURPOSE:
     * Adds an element to the queue.
     * PARAMETERS:
     * int x
     * RETURN VALUE:
     * void
     **/
   public void add(int x) {
      if (front == -1){
          front++;
          rear++;
          elements[rear] = x;
      } else if (rear == capacity - 1){
        rear = 0;
        elements[rear] = x;
      } else {
          rear++;
          elements[rear] = x;
      }
   }
    /**
     * MEMBER FUNCTION NAME:
     * ppublic int remove()
     * PURPOSE:
     * Removes an element from the queue.
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * int - value of the removed element
     **/
   public int remove() {
        int removed = elements[front];
        if (front == rear){
            front = -1;
            rear = -1;
        } else if (front == capacity - 1){
            front = 0;
        } else{
            front = front + 1;
        }
        return removed;
   }
    /**
     * MEMBER FUNCTION NAME:
     * public int peek()
     * PURPOSE:
     * Returns the value of the front element in the queue
     * without changing it. In case if the queue is empy,
     * returns -1 and displays error message.
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * int value of the front element in the queue
     **/
   public int peek() {
       if (front == -1){
           System.out.println("Error: queue is empty.");
           return  -1;
       }
       return elements[front];
   }
    /**
     * MEMBER FUNCTION NAME:
     * public boolean isEmpty()
     * PURPOSE:
     * Returns whether the queue is empty or not.
     * PARAMETERS:
     * -
     * RETURN VALUE:
     * boolean true if the queue is empty, false if it's not.
     **/
   public boolean isEmpty() {
     if (front == -1) {
         return true;
     } else{
         return false;
     }
   }
}