package Snapchat2.PhoneContactListMerge;

import java.util.*;

public class Solution {
    static class Record {
        String name;
        String phoneNumber;

        public Record(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }

    static class Person {
        List<Record> data;

        public Person() {
            this.data = new LinkedList<>();
        }
    }

    // Key -> Person pointer container -> Person pointer
    public List<List<Record>> aggregate(List<Record> callLog) {
        // 用Person[]来代替指针容器，这样可以不动声色地merge
        Map<String, Person[]> nIndex = new HashMap<>();   // Name index <Name, List<Record>>
        Map<String, Person[]> pIndex = new HashMap<>();   // Phone index <Phone, List<Record>>
        for (Record record : callLog) {
            if (nIndex.containsKey(record.name) && pIndex.containsKey(record.phoneNumber)) {
                // Might need to merge
                Person[] p1 = nIndex.get(record.name);
                Person[] p2 = pIndex.get(record.phoneNumber);
                if (!p1[0].equals(p2[0])) {
                    p1[0].data.addAll(p2[0].data);
                }
                p2[0] = p1[0];  // 只要改一个指向，不需要改其它所有的value
            } else if (nIndex.containsKey(record.name)) {
                // We have record for this guy, but with different phone numbers
                Person[] p = nIndex.get(record.name);
                p[0].data.add(record);
                pIndex.put(record.phoneNumber, p);  // add one entry in phone number index
            } else if (pIndex.containsKey(record.phoneNumber)) {
                // We have phone number for this guy, but with different names
                Person[] p = pIndex.get(record.phoneNumber);
                p[0].data.add(record);
                nIndex.put(record.name, p); // add one entry in name index
            } else {
                Person[] p = new Person[1];
                p[0] = new Person();
                p[0].data.add(record);
                nIndex.put(record.name, p);
                pIndex.put(record.phoneNumber, p);
            }
        }
        List<List<Record>> res = new LinkedList<>();
        for (Person[] p : new HashSet<>(nIndex.values())) { // 这里要去重
            res.add(p[0].data);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Record> callLog = new LinkedList<>();
        //(ABC,123), (ABC, 456), (BCD, 456)
        callLog.add(new Record("ABC","123"));
        callLog.add(new Record("ABC","456"));
        callLog.add(new Record("BCD","123"));
        callLog.add(new Record("WWW","111"));
        callLog.add(new Record("CCC","222"));
        System.out.println(new Solution().aggregate(callLog));
    }
}
