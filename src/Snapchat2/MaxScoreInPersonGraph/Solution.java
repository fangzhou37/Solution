package Snapchat2.MaxScoreInPersonGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    static class Person {
        int score;
        List<Person> nextSnap;

        public Person(int score) {
            this.score = score;
            nextSnap = new LinkedList<>();
        }
    }

    // DFS
    public int findMaxScore(Person root, int maxStep) {
        Set<Person> buffer = new HashSet<>(maxStep);
        int[] maxScore = new int[1];
        maxScore[0] = -1;
        dfs(root, buffer, 0, maxStep, maxScore);
        return maxScore[0];
    }

    private void dfs(Person cur, Set<Person> buffer, int curScore, int maxStep, int[] maxScore) {
        if (buffer.size() >= maxStep) {
            return;
        }
        if (buffer.contains(cur)) { // circle detected, skip
            return;
        }
        buffer.add(cur);
        curScore += cur.score;
        maxScore[0] = Math.max(maxScore[0], curScore);
        for (Person nextSnap : cur.nextSnap) {
            dfs(nextSnap, buffer, curScore, maxStep, maxScore);
        }
        buffer.remove(cur);
    }

    public static void main(String[] args) {
        Person root = new Person(1);
        root.nextSnap.add(new Person(2));
        root.nextSnap.add(new Person(3));
        Person p1 = new Person(1);
        root.nextSnap.add(p1);
        p1.nextSnap.add(new Person(1));
        Person p2 = new Person(3);
        p1.nextSnap.add(p2);
        p2.nextSnap.add(root);
        System.out.println(new Solution().findMaxScore(root, 1));
        System.out.println(new Solution().findMaxScore(root, 2));
        System.out.println(new Solution().findMaxScore(root, 3));
        System.out.println(new Solution().findMaxScore(root, 4));
    }
}
