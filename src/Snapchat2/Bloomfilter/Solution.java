package Snapchat2.Bloomfilter;

import java.util.BitSet;

class BloomFilter {
    private BitSet data;
    private HashFunction[] functions;
    private static final int HASH_FUNCTION_COUNT = 6;
    private static final int[] seed = new int[]{7, 11, 13, 31, 37, 61};
    private static final int DEFAULT_HASH_CAP = (2 << 31);

    static class HashFunction {
        private int seed;
        private int cap;

        public HashFunction(int seed, int cap) {
            this.seed = seed;
            this.cap = cap;
        }

        public int getHash(byte[] bytes) {
            int res = 0;
            for (byte b : bytes) {
                res = res * seed + b;   // hopefully not overflow
            }
            return res & (cap - 1);
        }
    }

    public BloomFilter(int CAPACITY) {
        functions = new HashFunction[HASH_FUNCTION_COUNT];
        for (int i = 0; i < HASH_FUNCTION_COUNT; i++) {
            functions[i] = new HashFunction(seed[i], DEFAULT_HASH_CAP);
        }
        data = new BitSet(CAPACITY);
    }

    public boolean mightContains(String s) {
        byte[] bytes = s == null ? new byte[0] : s.getBytes();
        for (HashFunction hash : functions) {
            if (!data.get(hash.getHash(bytes))) {
                return false;
            }
        }
        return true;
    }

    public void put(String s) {
        byte[] bytes = s == null ? new byte[0] : s.getBytes();
        for (HashFunction hash : functions) {
            data.set(hash.getHash(bytes), true);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "abcd",
                "abcd",
                "abce",
                "abcf",
                "ab",
                "ac",
                "a",
                "w",
                "abd",
                ""
        };
        BloomFilter bf = new BloomFilter(1000);
        for (String s : strings) {
            bf.put(s);
        }
        for (String s : strings) {
            System.out.println("Contains " + s + "? " + bf.mightContains(s));
        }

        strings = new String[] {
                "abwd",
                "abc",
                "ace",
                "af",
                "abb",
                "k",
                "aw",
                "wa",
                "abdd",
                ""
        };
        for (String s : strings) {
            System.out.println("Contains " + s + "? " + bf.mightContains(s));
        }

    }
}
