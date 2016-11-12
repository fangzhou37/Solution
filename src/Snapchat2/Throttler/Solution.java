package Snapchat2.Throttler;

import java.util.LinkedList;
import java.util.Random;

class Throttler {
    int qps;
    LinkedList<Long> pool;

    public Throttler(int qps) {
        this.qps = qps;
        pool = new LinkedList<>();
    }

    public boolean allowAccess() {
        long now = System.currentTimeMillis();
        while (!pool.isEmpty() && now - pool.getFirst() > 1000) {
            pool.removeFirst();
        }
        if (pool.size() >= qps) {
            return false;
        }
        pool.addLast(now);
        return true;
    }

    public String printPool() {
        StringBuffer sb = new StringBuffer(pool.size() * 3);
        sb.append('[');
        for (Long item :
                pool) {
            if (sb.length() > 1) {
                sb.append(',');
            }
            sb.append(item % 10000);
        }
        sb.append(']');
        return sb.toString();
    }
}

public class Solution {
    public static void main(String[] args) {
        Throttler throttler = new Throttler(3);
        for (int i = 0; i < 20; i++) {
            System.out.println("[" + System.currentTimeMillis()%10000 + "] Allow Access ? " + throttler.allowAccess() +
                    "  Pool: " + throttler.printPool());
            try {
                Thread.sleep(new Random().nextInt(8) * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
