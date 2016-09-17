package _149MaxPointsOnALine;

import java.text.DecimalFormat;
import java.util.*;

class Point {
    int x;
    int y;
    public static final String DELIMITOR = ",";

    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class Line {
    public String slope;
    public String intercept;
    public boolean slopeExist;

    public static final String DELIMITOR = ",";
    public static final DecimalFormat df = new DecimalFormat("#.######");

    Line(Point p1, Point p2) {
        if (p1.y == p2.y) {
            slopeExist = false;
            intercept = String.valueOf(p1.y);
        } else {
            slopeExist = true;
            double slop = 0.0;
            if (p1.x != p2.x) {
                slop = (double)(p1.y - p2.y) / (double)(p1.x - p2.x);
            }
            double interc = p1.y - slop * p1.x;

            slope = df.format(slop);
            intercept = df.format(interc);
        }
    }

    @Override
    public int hashCode() {
        if (!slopeExist) {
            return intercept.hashCode();
        }
        StringBuffer sb = new StringBuffer();
        sb.append(slope);
        sb.append(DELIMITOR);
        sb.append(intercept);
        return sb.toString().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        Line otherLine = (Line) other;
        if (slopeExist != otherLine.slopeExist) {
            return false;
        }
        if (!slopeExist) {
            return intercept.equals(otherLine.intercept);
        }
        return slope.equals(otherLine.slope) && intercept.equals(otherLine.intercept);
    }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int max = points.length > 0 ? 1 : 0;
        Map<Line, Set<Integer>> m = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                Line l = new Line(points[i], points[j]);
                if (!m.containsKey(l)) {
                    m.put(l, new HashSet<Integer>());
                }
                m.get(l).add(i);
                m.get(l).add(j);
                max = Math.max(max, m.get(l).size());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //[[0,0],[-1,-1],[2,2]]
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        Point p3 = new Point(0,0);
        System.out.println(
                new Solution().maxPoints(new Point[] {new Point(3,10), new Point(0,2), new Point(0,2), new Point(3,10)})
        );
    }
}
