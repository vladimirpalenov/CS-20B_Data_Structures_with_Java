import java.util.ArrayList;

public class HomeworkAssignment9_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.put("app", 100);
//        System.out.println(sol.getSum("ap"));     // returns 100 as "ap" is a prefix  to "app"
//        sol.put("ap", 1);
        System.out.println(sol.getSum("x"));      // returns 101 as "a" is a prefix to both keys in map
        sol.put("ap", 1);
//        System.out.println(sol.getSum("xyz"));    // returns 0 as "xyz" is not a prefix to any keys in map
//        sol.put("app", 8);    // replaces the value of the existing key "app" from 100 to 8
//        System.out.println(sol.getSum("ap"));     // returns 9 as "ap" is a prefix to both keys in map
    }
}
    class Solution {
        // Global variables
        ArrayList<KeyValue> pairs;
        KeyValue kVTemp;

        //Constructor
        public Solution() {
            pairs = new ArrayList<>();
            kVTemp = new KeyValue();
        }
        /**
         * MEMBER FUNCTION NAME:
         * public void put(String key, int value)
         * PURPOSE:
         * inserts a (key, value) pair into the map. If the input value already exists,
         * update it. The input key is an English prefix (String) and the value is a
         * non-negative integer.
         * PARAMETERS:
         * String key, int value
         * RETURN VALUE:
         * void
         **/
        public void put(String key, int value) {
            // YOUR CODE HERE
            for (int i = 0; i < pairs.size(); i++){
                kVTemp = pairs.get(i);
                if (key.equals(kVTemp.key)){
                    kVTemp.value = value;
                    return;
                }
            }
            KeyValue newKeyValue = new KeyValue();;
            newKeyValue.key = key;
            newKeyValue.value = value;
            pairs.add(newKeyValue);
        }
        /**
         * MEMBER FUNCTION NAME:
         * public void put(int key, int value)
         * PURPOSE:
         * returns a summation of all corresponding values of the keys in map that
         * start with such prefix. The input key is an English prefix.
         * PARAMETERS:
         * String key
         * RETURN VALUE:
         * int
         **/
        public int getSum(String key) {
            // YOUR CODE HERE
            int sum = 0;
            for (int i = 0; i < pairs.size(); i++){
                kVTemp = pairs.get(i);
                if (isPrefix(key, kVTemp.key)){
                    sum += kVTemp.value;
                }
            }
            return sum;
        }
        /**
         * MEMBER FUNCTION NAME:
         * public boolean isPrefix(String prefix, String key)
         * PURPOSE:
         * The function checks if the prefix is a prefix for the key. Returns true if
         * yes and false if not.
         * PARAMETERS:
         * String prefix, String key
         * RETURN VALUE:
         * boolean
         **/
        public boolean isPrefix(String prefix, String key) {
            boolean result = true;
            for (int i = 0; i < prefix.length(); i++){
                if (prefix.charAt(i) != key.charAt(i)){
                    return false;
                }
            }
            return result;
        }
        private class KeyValue {
            String key;
            int value;
        }
    }

