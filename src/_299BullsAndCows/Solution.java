package _299BullsAndCows;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] cowCandidates = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                bulls++;
                continue;
            } else {
                if (cowCandidates[sc-'0'] < 0) {
                    cows++;
                }
                cowCandidates[sc-'0']++;

                if (cowCandidates[gc-'0'] > 0) {
                    cows++;
                }
                cowCandidates[gc-'0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
