package _278FirstBadVersion;

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        int firstBad = -1;
        while (i <= j) {
            int mid = i + (j-i)/2;
            if (isBadVersion(mid)) {
                firstBad = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return firstBad;
    }
}
