package Flatten2DArray;

import java.util.*;

public class Solution {
    private Iterator<List<Integer>> mRowIter;
    private Iterator<Integer> mColIter;

    public Solution(List<List<Integer>> list) {
        mRowIter = list.iterator();
    }

    public boolean has_next() {
        while (mColIter == null || !mColIter.hasNext()) {
            if (mRowIter.hasNext()) {
                mColIter = mRowIter.next().iterator();
            } else {
                return false;
            }
        }
        return mColIter != null && mColIter.hasNext();
    }

    public Integer next() {
        if (has_next()) {
            return mColIter.next();
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        if (mColIter != null) {
            mColIter.remove();
        } else {
            throw new IllegalStateException();
        }
    }

    /*
    Given: [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
    Print: 1 2 3 4 5 6 7 8 9 10
    Remove even elements
    Given: [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
    Should result in: [[],[1,3],[5],[],[],[],[7],[],[9],[],[]]
    Print: 1 3 5 7 9 */
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {1,2,3})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {4,5})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {6})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {7,8})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {9})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {10})));
        list.add(new LinkedList<>(Arrays.asList(new Integer[] {})));
        Solution s = new Solution(list);
        int i = 0;
        while (s.has_next()) {
            s.next();
            if ((i & 1) == 1) {
                s.remove();
            }
            i++;
        }
        s = new Solution(list);
        while (s.has_next()) {
            System.out.println(s.next());
        }
    }
}
