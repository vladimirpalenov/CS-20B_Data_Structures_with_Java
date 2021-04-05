import java.util.*;
public class HomeworkAssignment11_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        // let's create a cycle with c -> b
        a.next = b;
        a.next.next = c;
        c.next = b;
        System.out.println(sol.hasCycle(a)); // true
    }
}
    class Node {
        String label;
        Node next;
        public Node(String label) {
            this.label = label;
        }
        public String toString() {return label;}
    }

    class Solution {
        /**
         * MEMBER FUNCTION NAME:
         * public boolean hasCycle(Node head)
         * PURPOSE:
         * This function takes in the head Node as an argument and checks
         * if the directed graph has a loop.
         * PARAMETERS:
         * Node head
         * RETURN VALUE:
         * boolean true or false
         **/
        public boolean hasCycle(Node head) {
            ArrayList<Node> nodeAList = new ArrayList<Node>();
            boolean result = false;
            if (head == null) {
                return result;
            }
            if (head.next == null){
                return result;
            }
            nodeAList.add(head);
            while (head.next != null){
                head = head.next;
                if (nodeAList.contains(head)){
                    result = true;
                    break;
                } else{
                    nodeAList.add(head);
                }
            }
            return result;
        }
    }