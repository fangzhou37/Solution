package Snapchat.Bloomfilter;

import java.util.LinkedList;
import java.util.List;

public class BloomFilterExt {
    private int CAPACITY_EXPONENT;
    private int[] data;
    private int CAPACITY;
    private HashFunction[] functions;
    private static final int HASH_FUNCTION_COUNT = 6;
    private static final int[] seed = new int[]{7, 11, 13, 31, 37, 61};
    private List<String> fullRecords = new LinkedList<>();

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
            return (res % cap + cap)%cap;
        }
    }

    // capacity should be less than 32
    public BloomFilterExt(int CAPACITY_EXPONENT) {
        this.CAPACITY_EXPONENT = CAPACITY_EXPONENT;
        CAPACITY = (2 << CAPACITY_EXPONENT);
        data = new int[CAPACITY];
        functions = new HashFunction[HASH_FUNCTION_COUNT];
        for (int i = 0; i < HASH_FUNCTION_COUNT; i++) {
            functions[i] = new HashFunction(seed[i], CAPACITY);
        }
    }

    public boolean mightContains(String s) {
        byte[] bytes = s == null ? new byte[0] : s.getBytes();
        for (HashFunction hash : functions) {
            if (data[hash.getHash(bytes)] == 0) {
                return false;
            }
        }
        return true;
    }

    public void put(String s) {
        putInternal(s);
        fullRecords.add(s);
    }

    private void putInternal(String s) {
        byte[] bytes = s == null ? new byte[0] : s.getBytes();
        for (HashFunction hash : functions) {
            data[hash.getHash(bytes)]++;
        }
    }

    public void delete(String s) {
        byte[] bytes = s == null ? new byte[0] : s.getBytes();
        for (HashFunction hash : functions) {
            data[hash.getHash(bytes)]--;
        }
        fullRecords.remove(s);
    }

    public void resize(int newCapacityExponent) {
        if (newCapacityExponent <= CAPACITY_EXPONENT) {
            return;
        }

        CAPACITY_EXPONENT = newCapacityExponent;
        CAPACITY = (2 << CAPACITY_EXPONENT);
        data = new int[CAPACITY];
        for (String record : fullRecords) {
            putInternal(record);
        }
    }

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
        BloomFilterExt bf = new BloomFilterExt(12);
        for (String s : strings) {
            bf.put(s);
        }
        for (String s : strings) {
            System.out.println("Contains " + s + "? " + bf.mightContains(s));
        }

        System.out.println("---------Should not contains----------");
        String[] should_not_contains_set = new String[] {
                "abwd",
                "abc",
                "ace",
                "af",
                "abb",
                "k",
                "aw",
                "wa",
                "abdd"
        };
        for (String s : should_not_contains_set) {
            System.out.println("Contains " + s + "? " + bf.mightContains(s));
        }

        System.out.println("---------Remove some elements----------");
        bf.delete("abce");
        bf.delete("ab");
        bf.delete("w");
        for (String s : strings) {
            System.out.println("Contains " + s + "? " + bf.mightContains(s));
        }

        System.out.println("---------Resize----------");
        bf.resize(15);
        for (String s : strings) {
            System.out.println("Contains " + s + "? " + bf.mightContains(s));
        }
    }
}
