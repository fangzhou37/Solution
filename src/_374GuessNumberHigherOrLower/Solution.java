package _374GuessNumberHigherOrLower;

public class Solution {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while(i < j) {
            int mid = i + (j - i) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    /*
        The guess API is defined in the parent class GuessGame.
        @param num, your guess
        @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
    */
    private int guess(int mid) {
        return 0;
    }
}
