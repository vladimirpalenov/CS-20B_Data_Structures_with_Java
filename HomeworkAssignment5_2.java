
public class HomeworkAssignment5_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] test1 = {3,4,5,6};
        int [] test2 = {1};
        int [] test3 = {1, 3, 2, 3, 4, 1, 3, 5, 2, 1};
        int [] test4 = {1};
        System.out.println(sol.canDistribute(test1, 2)); //true
        System.out.println(sol.canDistribute(test2, 1)); //true
        System.out.println(sol.canDistribute(test3, 5)); //true
        System.out.println(sol.canDistribute(test4, 4)); //false
    }
}
class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * public boolean canDistribute(int[] resources, int groups)
     * PURPOSE:
     * Returns whether it is possible (true or false) that a given set of resources
     * divides into groups equal-sum facilities.
     * PARAMETERS:
     * (int[] resources, int groups)
     * RETURN VALUE:
     * boolean true if it's possible to divide, false if not.
     **/
    public boolean canDistribute(int[] resources, int groups) {
        int sumRes = 0;
        for (int i : resources)
            sumRes += i;
        int alloc = sumRes % groups;
        if (groups == 1){
            return true;
        } else if (groups > resources.length){
            return false;
        } else if (alloc != 0){
            return false;
        }
        int subSet = sumRes / groups;
        int [] subSetSum = new int [groups];
        boolean []taken = new boolean[resources.length];
        for (int i = 0; i < groups; i++) {
            subSetSum[i] = 0;
        }
        for (int i = 0; i < resources.length; i++){
            taken[i] = false;
        }
        subSetSum[0] = resources[resources.length - 1];
        taken[resources.length - 1] = true;
        return recursiveSubPartitions(resources, subSetSum, taken, subSet, groups, resources.length, 0, resources.length - 1);
    }
    /**
     * MEMBER FUNCTION NAME:
     * static boolean recursiveSubPartitions(int arr[], int subsetSum[], boolean taken[], int subset, int subsetNum, int arrLen, int curIdx, int limitIdx)
     * PURPOSE:
     * Method to check if number of partitions needed equals to sum subsetition of array.
     * PARAMETERS:
     * int arr[], int subsetSum[], boolean taken[], int subset, int subsetNum, int arrLen, int curIdx, int limitIdx
     * RETURN VALUE:
     * boolean true or false.
     **/
    static boolean recursiveSubPartitions(int arr[], int subsetSum[], boolean taken[], int subset, int subsetNum, int arrLen, int curIdx, int limitIdx){
        if (subsetSum[curIdx] == subset){
            if (curIdx == subsetNum - 2) {
                return true;
            }
            return recursiveSubPartitions(arr, subsetSum, taken, subset, subsetNum, arrLen, curIdx + 1, arrLen - 1);
        }
        for (int i = limitIdx; i >= 0; i--)
        {
            if (taken[i])
                continue;
            int tmp = subsetSum[curIdx] + arr[i];
            if (tmp <= subset)
            {
                taken[i] = true;
                subsetSum[curIdx] += arr[i];
                boolean nxt = recursiveSubPartitions(arr, subsetSum, taken, subset, subsetNum, arrLen, curIdx, i - 1);
                taken[i] = false;
                subsetSum[curIdx] -= arr[i];
                if (nxt)
                    return true;
            }
        }
        return false;
    }
}