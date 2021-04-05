

public class HomeworkAssignment9_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.put(1, 1);
        sol.put(2, 3);
        sol.put(3, 4);
        sol.put(4, 5);
        sol.put(5, 6);
        sol.put(20, 0);
        sol.put(90, 3);
        sol.put(12, 13);
        sol.put(72, 73);
        sol.put(28, 300);
        sol.put(23, 777);
        System.out.println(sol.get(3));     // returns 4
        System.out.println(sol.get(1));       // returns 1
        System.out.println(sol.get(30));      // returns -1 (not found)
        System.out.println(sol.get(5));      // returns 6
        System.out.println(sol.get(72));      // returns 73
        System.out.println(sol.get(28));      // returns 300
        System.out.println(sol.get(23));      // returns 777
        System.out.println(sol.get(20));       // returns 0
        sol.put(1, 100);  // update the existing value
        sol.put(20, 50);  // update the existing value
        System.out.println(sol.get(1));       // returns 100
        System.out.println(sol.get(20));       // returns 50
        sol.remove(2);    // removes the mapping for 2
        sol.remove(1);    // removes the mapping for 1
        sol.remove(20);   // removes the mapping for 20
        System.out.println(sol.get(2));       // returns -1 (not found)
        System.out.println(sol.get(1));       // returns -1 (not found)
        System.out.println(sol.get(20));       // returns -1 (not found)
    }
}


    class Solution {
    // Global variables
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    int[][] elements;

    // Constructor
    public Solution() {
        elements = new int [DEFAULT_CAPACITY][2];
    }

        /**
         * MEMBER FUNCTION NAME:
         * public void put(int key, int value)
         * PURPOSE:
         * inserts a (key, value) pair into the map.
         * If the input value already exists, update it.
         * Both key and value are integers.
         * PARAMETERS:
         * int key, int value
         * RETURN VALUE:
         * void
         **/
    public void put(int key, int value) {
        if (size == 0){
            elements[size][0] = key;
            elements[size][1] = value;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i][0] == key) {
                    elements[i][1] = value;
                } else {
                    if (size == elements.length) {
                        resize();
                    }
                    elements[size][0] = key;
                    elements[size][1] = value;
                }
            }
            size++;
        }
    }

        /**
         * MEMBER FUNCTION NAME:
         * public int get(int key)
         * PURPOSE:
         * This function finds the value corresponding to the given key
         * and returns it. If the key does not exist -1 is returned.
         * PARAMETERS:
         * int key
         * RETURN VALUE:
         * int value corresponding to the key. If the key is not found: -1;
         **/
    public int get(int key) {
        int result = -1;
        for (int i = 0; i < elements.length; i++){
            if (elements[i][0] == key){
                result = elements[i][1];
            }
        }
        return result;
    }

        /**
         * MEMBER FUNCTION NAME:
         * public void remove(int key)
         * PURPOSE:
         * This function finds a key-value pair given the key as input.
         * Changes the corresponding value to -1 (Not found).
         * PARAMETERS:
         * int key
         * RETURN VALUE:
         * void
         **/
    public void remove(int key) {
        for (int i = 0; i < elements.length; i++){
            if (elements[i][0] == key){
                elements[i][1] = -1;
            }
        }
    }

        /**
         * MEMBER FUNCTION NAME:
         * private void resize()
         * PURPOSE:
         * Changes default size of the array by doubling it's size.
         * PARAMETERS:
         * -
         * RETURN VALUE:
         * void
         **/
    private void resize() {
        int newSize = elements.length * 2;
        int b[][] = new int[newSize][2];
        for (int i = 0; i < elements.length; i++){
            b[i] = elements[i];
        }
        elements = b;
    }
}


