package CircularBuffer;

class CircularBuffer<T> {
    private T[] buf;
    private int start = 0;
    private int end = 0;

    public CircularBuffer(int size) {
        buf = (T[]) new Object[size];
        if (size == 0) {
            // throw new Exception("Size of the buffer should not be zero!");
        }
    }

    private int incre(int index) {
        index = (index + 1) % buf.length;
        if (index < 0) {
            index += buf.length;
        }
        return index;
    }

    // start == end 有两种情况
    // 一种是, buf为空: buf[start] == null, 此时,buf[end] = obj 后,无需incre(end)
    // 如果buf[start] != null, 那么buf[end] = obj; end = incre(end); 且如果数组已满(start==newEnd),要调整start
    public void add(T obj) {
        if (end == start && buf[start] == null) {
            buf[end] = obj;
            return;
        }
        end = incre(end);
        buf[end] = obj;
        if (end == start) {
            start = incre(start);
        }
    }

    public T get() {
        T res = buf[start];
        if (start == end) { // 数组为空或者只有一个元素
            buf[start] = null;
            return res;
        }
        start = incre(start);
        return res;
    }
}

public class Solution {

    public static void main(String[] args) {
        CircularBuffer<Integer> buf = new CircularBuffer<Integer>(5);
        for (int i = 0; i < 10; i++) {
            buf.add(i);
        }
        Integer i = buf.get();
        while (i != null) {
            System.out.println(i);
            i = buf.get();
        }
        buf.add(10);
        buf.add(11);
        buf.add(12);
        System.out.println(buf.get());
        buf.add(13);
        buf.add(14);
        buf.add(15);
        buf.add(16);
        System.out.println(buf.get());

    }
}
