public class HomeworkAssignment12 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findThatSock(new int[]{1,1,2,2,3,3,4})==4);
        System.out.println(sol.findThatSock(new int[]{1})==1);
    }
}

class Solution {
    // global variable to store the value of the unpaired element
    public static int unpaired;
    /**
     * MEMBER FUNCTION NAME:
     * public int findThatSock(int[] socks)
     * PURPOSE:
     * This function finds the unpaired element in a sorted integer array
     * and returns it's value.
     * PARAMETERS:
     * int[] socks
     * RETURN VALUE:
     * int
     **/
    public int findThatSock(int[] socks) {
        int left = 0;
        int right = socks.length - 1;
        recursiveFind(socks, left, right);
        return Solution.unpaired;
    }
    /**
     * MEMBER FUNCTION NAME:
     * public void recursiveFind(int[] socks, int left, int right)
     * PURPOSE:
     * This function implements recursive search for the unpaired
     * element in a sorted int array. It stores the found value in
     * the global variable.
     * and returns it's value.
     * PARAMETERS:
     * int[] socks, int left, int right
     * RETURN VALUE:
     * void
     **/
    public void recursiveFind(int[] socks, int left, int right) {
        if (left == right) {
            Solution.unpaired = socks[left];
        } else {
            int mid = (left + right) / 2;
            if (mid % 2 == 0) {
                if (socks[mid] == socks[mid + 1])
                    recursiveFind(socks, mid + 2, right);
                else
                    recursiveFind(socks, left, mid);
            }
            else if (mid % 2 == 1) {
                if (socks[mid] == socks[mid - 1])
                    recursiveFind(socks, mid + 1, right);
                else
                    recursiveFind(socks, left, mid - 1);
            }
        }
    }
}

