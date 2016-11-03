package Snapchat2.Radar;

import java.util.*;

public class Solution {
    static class Radar {
        double x;
        double y;
        double r;
        public Radar(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    class Area {
        List<Radar> radars;
        double upperbound;
        double lowerbound;

        public Area() {
            radars = new ArrayList<Radar>();
            upperbound = 0;
            lowerbound = 1;
        }

        private boolean canMerge(Radar r1, Radar r2) {
            return Math.pow(r1.r + r2.r, 2) >= Math.pow(r1.x - r2.x, 2) + Math.pow(r1.y - r2.y, 2);
        }

        private boolean merge(Radar r) {
            for(Radar radar: radars) {
                if(canMerge(r, radar)) {
                    upperbound = Math.max(upperbound, r.y + r.r);
                    lowerbound = Math.min(lowerbound, r.y - r.r);
                    radars.add(r);
                    return true;
                }
            }
            return false;
        }

        private boolean cannotPass() {
            return upperbound >= 1 && lowerbound <= 0;
        }
    }


    public boolean canCarPass(List<Radar> radars) {
        List<Area> area = new ArrayList<Area>();
        for(Radar radar: radars) {
            boolean merged = false;
            for(Area a: area) {
                merged = a.merge(radar);
                if(merged) {
                    break;
                }
            }
            if(!merged) {
                Area a = new Area();
                a.radars.add(radar);
                area.add(a);
            }
        }
        for(Area a : area) {
            if(a.cannotPass()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution rd = new Solution();
        //List<Radar> radars = Arrays.asList(new Radar(1, 0.5, 0.49), new Radar(3, 1.5, 1), new Radar(3, 0.4, 0.3));
        List<Radar> radars = Arrays.asList(new Radar(1, 0, 0.7),new Radar(2,1,0.41), new Radar(2,0.1,0.5));
        //List<Radar> radars = Arrays.asList(new Radar(1, 0, 1.5), new Radar(3, 1, 1.5));
        System.out.println(rd.canCarPass(radars));
    }
}
