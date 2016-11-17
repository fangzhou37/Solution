package Snapchat2.Counter;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Solution {
    static class Counter {
        class InternalCounter {
            private int count;

            public synchronized void increment() {
                count++;
            }

            public synchronized int getCount() {
                return count;
            }
        }

        final int POOL_SIZE;
        InternalCounter[] pool;
        Random r;

        ReentrantReadWriteLock lock;

        public Counter(int poolSize) {
            POOL_SIZE = poolSize;
            pool = new InternalCounter[POOL_SIZE];
            for (int i = 0; i < POOL_SIZE; i++) {
                pool[i] = new InternalCounter();
            }
            r = new Random();
            lock = new ReentrantReadWriteLock(true);
        }

        public int increment() {
            lock.readLock().lock();
            try {
                int index = r.nextInt() % POOL_SIZE;
                if (index < 0) {
                    index += POOL_SIZE;
                }
                pool[index].increment();
                return index;
            } finally {
                lock.readLock().unlock();
            }
        }

        public int check() {
            int res = 0;
            lock.writeLock().lock();
            try {
                for (InternalCounter counter : pool) {
                    res += counter.getCount();
                }
            } finally {
                lock.writeLock().unlock();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        final Counter counter = new Counter(3);
        final Random r = new Random();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int index = counter.increment();
                    System.out.println("increment. Index: " + index);
                    try {
                        Thread.sleep(r.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread[] threads = new Thread[50];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].run();
        }
        System.out.println(counter.check());
    }
}
