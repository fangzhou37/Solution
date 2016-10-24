package Snapchat.ListIterator;

import java.util.*;

public class Solution {
    static class MyIterator implements Iterator{
        private final List<Integer> mList;
        private final List<Integer> mArrayList;
        private int mIndex;

        public MyIterator(List<Integer> list) {
            mList = list;
            mArrayList = new ArrayList<>(list);
            mIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return mIndex < mList.size();
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return mArrayList.get(mIndex++);
        }

        @Override
        public void remove() {
            if (mIndex == 0) {
                throw new IndexOutOfBoundsException();
            }
            mList.remove(mIndex-1);
            mArrayList.remove(mIndex-1);
            mIndex--;
        }
    }

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        Iterator<Integer> iter = new MyIterator(l);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("-----------------------");


        iter = new MyIterator(l);
        while (iter.hasNext()) {
            int value = iter.next();
            System.out.println(value);
            if (new Random().nextInt() % 3 == 0) {
                System.out.println("Remove last value: " + value);
                iter.remove();
            }
        }
        System.out.println("-----------------------");

        iter = new MyIterator(l);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
