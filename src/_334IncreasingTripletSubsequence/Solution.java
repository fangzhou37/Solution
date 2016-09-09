package _334IncreasingTripletSubsequence;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) { // if n == min, ignore it, don't let it enter next 'if'
                min = n;    // secondMin is the 'guard', no harm to set min
            } else if (n <= secondMin) {    // if n == secondMin, ignore it, don't let it enter next 'if'
                secondMin = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{2,4,1,5}));
    }
}
