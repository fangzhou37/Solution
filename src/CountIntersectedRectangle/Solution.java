package CountIntersectedRectangle;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static class Rect {
        public Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        int x1;
        int y1;
        int x2;
        int y2;
    }

    //Sort the rectangles according to low_x().                     # O(n log n)
    //For each rectangle in sorted array:                           # O(n)
    //  Finds its highest X point.                                  # O(1)
    //  Compare it with all rectangles whose low_x() is smaller     # O(log n)
    //  than this.high(x)

    public int count(Rect[] rects) {
        Arrays.sort(rects, new Comparator<Rect>() {
            @Override
            public int compare(Rect o1, Rect o2) {
                return o1.x1 - o2.x1;
            }
        });
        int count = 0;
        for (int i = 0; i < rects.length; i++) {
            int curEndX = rects[i].x2 + 1;
            int index = Arrays.binarySearch(rects, i + 1, rects.length, new Rect(curEndX, 0, 0, 0),
                    new Comparator<Rect>() {
                @Override
                public int compare(Rect o1, Rect o2) {
                    return o1.x1 - o2.x1;
                }
            });
            index = Math.abs(index);
            for (int j = i+1; j < index && j < rects.length; j++) {
                if (isIntersect(rects[i], rects[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isIntersect(Rect r1, Rect r2) {
        return !(r1.x1 > r2.x2 || r2.x1 > r1.x2 || r1.y2 > r2.y1 || r2.y2 > r1.y1);
    }

    public static void main(String[] args) {
        Rect[] rects = new Rect[] {
                new Rect(0,4,3,0),
                new Rect(2,3,5,1),
                new Rect(2,3,5,1),
                new Rect(1,7,7,2),
                new Rect(1,6,2,5),
                new Rect(1,6,2,5),
                new Rect(4,6,6,5),
        };
        System.out.println(new Solution().count(rects));
    }
}
