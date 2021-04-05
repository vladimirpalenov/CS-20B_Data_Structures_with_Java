import java.util.Stack;


public class HomeworkAssignment3_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //test case #1
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = null;
        sol.mixList(node1); // list be homogeneous after this call
        sol.printList(node1);
        //test case #2
        Node node2 = new Node(1);
        node2.next = null;
        sol.mixList(node2); // list be homogeneous after this call
        sol.printList(node2);
        //test case #3
        Node node3 = new Node(1);
        node3.next = new Node(2);
        node3.next.next = null;
        sol.mixList(node3); // list be homogeneous after this call
        sol.printList(node3);
        //test case #4
        Node node4 = new Node(1);
        node4.next = new Node(2);
        node4.next.next = new Node(3);
        node4.next.next.next = new Node(4);
        node4.next.next.next.next = new Node(5);
        node4.next.next.next.next.next = null;
        sol.mixList(node4); // list be homogeneous after this call
        sol.printList(node4);
    }
}


class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
}


class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * public void mixList(Node head)
     * PURPOSE:
     * Takes in a sorted link list of integers,
     * and makes it homogenous.
     * PARAMETERS:
     * Node head
     * RETURN VALUE:
     * void
     **/
    public void mixList(Node head) {
        Node copy = head;
        int listSize = countList(head);
        int half = (listSize % 2 == 0) ? listSize/2 : listSize/2+1;
        int [] arr1 = new int [half];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, d = 0; i < listSize; i++){
            if (i < half){
                arr1[d] = copy.val;
                copy = copy.next;
                d++;
            } else {
                stack.push(copy.val);
                copy = copy.next;
            }
        }
        int c = 0;
        for (int b = 0; b < listSize; b++){
            if (b % 2 == 0){
                head.val = arr1[c];
                c++;
                head = head.next;
            } else {
                head.val = stack.pop();
                head = head.next;
            }
        }
    }

    /**
     * MEMBER FUNCTION NAME:
     * public int countList(Node head)
     * PURPOSE:
     * Takes in a linked list and counts a number of elements in it.
     * PARAMETERS:
     * (Node head)
     * RETURN VALUE:
     * int count, number of elements in linked list.
     **/
    public int countList(Node head) {
        int count = 1;
        Node current = head;
        while (current.next != null){
            count++;
            current = current.next;
        }
        return count;
    }
    /**
     * MEMBER FUNCTION NAME:
     * public void printList(Node head)
     * PURPOSE:
     * Takes in a linked list and prints it in a form:
     * 1->2->3->4->null
     * PARAMETERS:
     * Node head
     * RETURN VALUE:
     * void
     **/
    public void printList(Node head) {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val + "->null");
    }



}
