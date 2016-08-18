package _380InsertDeleteGetRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    ArrayList<Integer> arr;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean containsKey =  map.containsKey(val);
        if (!containsKey) {
            arr.add(val);
            map.put(val, arr.size() - 1);
        }
        return !containsKey;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean containsKey =  map.containsKey(val);
        if (containsKey) {
            int index = map.get(val);
            int lastIndex = arr.size() - 1;
            int lastElement = arr.get(lastIndex);
            swap(arr, index, lastIndex);
            map.put(lastElement, index);
            map.remove(val);
            arr.remove(arr.size() - 1);
        }
        return containsKey;
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
