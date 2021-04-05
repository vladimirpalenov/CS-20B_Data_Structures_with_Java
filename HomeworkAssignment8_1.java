public class HomeworkAssignment8_1 {
    public static void main(String[] args) {
        // Test case 1
        Solution sol = new Solution();
        BSTNode tree = new BSTNode(0);
        tree.left    = new BSTNode(0);
        tree.right   = new BSTNode(1);
        tree.left.left    = new BSTNode(1);
        tree.right.left    = new BSTNode(1);
        tree.right.right    = new BSTNode(3);
        System.out.println(sol.distribute(tree)); //5
    }
}

class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;
    BSTNode(int x) { val = x; }
}

class Solution {
    // Global variable to store number of moves
    static int moves = 0;
    /**
     * MEMBER FUNCTION NAME:
     * public int distribute(BSTNode tree)
     * PURPOSE:
     * Calculate number of moves to equally distribute
     * number of BST between nodes.
     * PARAMETERS:
     * BSTNode tree
     * RETURN VALUE:
     * int number of moves
     **/
    public int distribute(BSTNode tree) {
        distributeBST(tree);
        return moves;
    }
    /**
     * UTILITY FUNCTION NAME:
     * public int distributeBST(BSTNode root)
     * PURPOSE:
     * Calculate number of moves to equally distribute
     * number of BST between nodes.
     * PARAMETERS:
     * BSTNode tree
     * RETURN VALUE:
     * int number of moves to balance current node
     **/
    public int distributeBST(BSTNode root) {
        if (root == null) {
            return 0;
        }
        int left = distributeBST(root.left);
        int right = distributeBST(root.right);
        moves = moves + Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}