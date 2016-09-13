package _284PeekingIterator;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iter;
    private Integer nextCache = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        if (iter.hasNext()) {   // simplify the problem, make sure cache is filled
            nextCache = iter.next();
        }
    }

    public Integer peek() {
        return nextCache;
    }

    @Override
    public Integer next() {
        Integer cur = nextCache;
        if (iter.hasNext()) {   // refresh cache
            Integer next = iter.next();
            nextCache = next;
        } else {
            nextCache = null;
        }
        return cur;
    }

    @Override
    public boolean hasNext() {
        return nextCache != null;
    }

    @Override
    public void remove() {

    }
}

public class Solution {

}
