import java.util.*;
public class HomeworkAssignment7 {
    public static void main(String[] args) {
        // EXAMPLE CODE
        System.out.println("Example code:");
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
        MyIterator iter = new MyIterator(ints.iterator());
        System.out.println(iter.next());         // 1
        System.out.println(iter.lookAhead());    // 2
        System.out.println(iter.next());         // 2
        System.out.println(iter.next());         // 3
        System.out.println(iter.hasNext());      // false
        // TEST CASE #1
        System.out.println("Test case 1:");
        List<Integer> ints1 = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        MyIterator iter1 = new MyIterator(ints1.iterator());
        System.out.println(iter1.next());      // 1
        System.out.println(iter1.lookAhead()); // 2
        System.out.println(iter1.next());      // 2
        System.out.println(iter1.next());      // 3
        System.out.println(iter1.hasNext());   // true

        // TEST CASE #2
        System.out.println("Test case 2:");
        List<Integer> ints2 = new ArrayList<>(Arrays.asList(100));
        MyIterator iter2 = new MyIterator(ints2.iterator());
        System.out.println(iter2.next());      // 100
        System.out.println(iter2.lookAhead()); // null
        System.out.println(iter2.next());      // null
        System.out.println(iter2.hasNext());   // false
    }
}
class MyIterator implements Iterator<Integer> {

    // ==============================================
    // ANY GLOBAL VARIABLE DECLARATIONS HERE
    // ==============================================
    //a list to store Iterator elements
    List<Integer> myList = new ArrayList<Integer>();
    //counter variable to help iterate over the list
    int count = -1;
    //a custom constructor
    public MyIterator(Iterator<Integer> iterator) {
        iterator.forEachRemaining(myList::add);
    }
    // Returns the next element in the iteration WITHOUT
    // advancing the iterator.
    public Integer lookAhead() {
        if (hasNext()){
            return myList.get(count + 1);
        }else {
            return null;
        }
    }
    //method returns the next element in the iteration
    @Override
    public Integer next() {
        if (hasNext()) {
            count++;
            return myList.get(count);
        }else {
            return null;
        }
    }
    //method returns the next element in the iteration
    @Override
    public boolean hasNext() {
        if (myList.size() > count+1)
            return true;
        else
            return false;
    }
}
