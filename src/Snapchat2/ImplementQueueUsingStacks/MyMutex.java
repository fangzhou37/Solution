package Snapchat2.ImplementQueueUsingStacks;

import sun.misc.Unsafe;

public class MyMutex {
    private Thread owner = null;
    private long locks = 0;
    private Unsafe unsafe = Unsafe.getUnsafe();

    public synchronized void lock() {
        Thread me = Thread.currentThread();
        while (locks > 0 && owner != me) {
            try {
                //若被叫醒回來發現lock大於0的話，則再回去wait set。
                wait();
            } catch (InterruptedException e) {
            }
            /*if (locks == 0 && owner == null) {
                unsafe.compareAndSwapObject(owner, unsafe.objectFieldOffset(...), null, me);
            }*/
        }
        // locks == 0 || owner == me
        owner = me;
        locks++;
    }
    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        if (locks == 0 || owner != me) {
            return;
        }
        // locks > 0 && owner == me
        locks--;
        if (locks == 0) {
            owner = null;
            notifyAll();
        }
    }
}