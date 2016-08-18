package _381InsertDeleteGetRandomWithDup;

import java.util.*;

class RandomizedCollection {
    ArrayList<Integer> arr;
    Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean containsKey =  map.containsKey(val);
        if (!containsKey) {
            arr.add(val);
            Set<Integer> s = new HashSet<>();
            s.add(arr.size() - 1);
            map.put(val, s);
        } else{
            arr.add(val);
            map.get(val).add(arr.size() - 1);
        }
        return !containsKey;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean containsKey = map.containsKey(val);
        if (containsKey) {
            int index = popOneElement(val);
            int lastIndex = arr.size() - 1;
            if (index != lastIndex) {
                int lastElement = arr.get(lastIndex);
                swap(arr, index, lastIndex);
                Set<Integer> lastElementIndexSet = map.get(lastElement);
                lastElementIndexSet.remove(lastIndex);
                lastElementIndexSet.add(index);
            }
            arr.remove(arr.size() - 1);

        }
        return containsKey;
    }

    private int popOneElement(int val) {
        Set<Integer> indexSet = map.get(val);
        int index = indexSet.iterator().next();
        indexSet.remove(index);
        if (indexSet.isEmpty()) {
            map.remove(val);
        }
        return index;
    }

    private void swap(ArrayList<Integer> arr, int i, int j) {
        int t = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, t);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(new Random().nextInt(arr.size()) );
    }
}
public class Solution {

    public static void main(String[] args) {
        // write your code here
    }
}
