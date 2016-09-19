package _223RectangleArea;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 如果不重合，Math.max(A, E) > Math.min(C, G) => right == left
        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F), top = Math.max(Math.min(D, H), bottom);
        return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}
