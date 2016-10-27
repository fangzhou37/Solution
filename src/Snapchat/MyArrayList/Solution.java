package Snapchat.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyArrayList<T> {
    private int mInd;
    T[] arr;

    public MyArrayList(int initCapacity) {
        arr = (T[]) new Object[initCapacity];
        mInd = 0;
    }

    public int size() {
        return mInd;
    }

    public boolean isEmpty() {
        return mInd == 0;
    }

    public boolean add(T obj) {
        ensureCapacity(mInd + 1);
        arr[mInd++] = obj;
        return true;
    }

    public boolean removeObject(T o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        System.arraycopy(arr, index+1, arr, index, mInd - index - 1);
        mInd--;
        return true;
    }

    private int indexOf(T o) {
        for (int i = 0; i < mInd; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, T element) {
        ensureCapacity(mInd + 1);
        mInd++;
        rangeCheck(index);
        System.arraycopy(arr, index, arr, index+1, mInd - index);
        arr[index] = element;
    }

    public T remove(int index) {
        rangeCheck(index);
        T obj = arr[index];
        System.arraycopy(arr, index+1, arr, index, mInd - index - 1);
        mInd--;
        return obj;
    }

    public T get(int index) {
        rangeCheck(index);
        return arr[index];
    }

    public T set(int index, T element) {
        rangeCheck(index);
        return arr[index] = element;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > mInd) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int newSize) {
        while (arr.length <= newSize) {
            doubleCapacity();
        }
    }

    private void doubleCapacity() {
        arr = Arrays.copyOf(arr, arr.length * 2);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (int i = 0; i < mInd; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append(']');
        return sb.toString();
        //return "MyArrayList{" + Arrays.toString(Arrays.copyOfRange(arr, 0, mInd)) + '}';
    }
}

public class Solution {
    public static void main(String[] args) {
        MyArrayList<Integer> arrList = new MyArrayList<Integer>(2);
        List<Integer> realList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrList.add(i);
            realList.add(i);
            System.out.println(arrList);
        }
        for (int i = -1; i >= -10; i--) {
            arrList.add(0, i);
            realList.add(i);
            System.out.println(arrList);
        }

        System.out.println("Gradually remove elements, one by one.");
        int size = arrList.size();
        for (int i = 0; i < size; i++) {
            arrList.remove(0);
            System.out.println(arrList);
        }

        // Re-add
        for (int i = 0; i < 10; i++) {
            arrList.add(i);
            System.out.println(arrList);
        }
        for (int i = -1; i >= -10; i--) {
            arrList.add(0, i);
            System.out.println(arrList);
        }
        System.out.println("Gradually randomly remove elements, one by one.");
        Collections.shuffle(realList);
        for (Integer i : realList) {
            System.out.println("Remove: " + i);
            arrList.removeObject(i);
            System.out.println(arrList);
        }
    }
}
