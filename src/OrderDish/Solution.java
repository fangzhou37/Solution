package OrderDish;

import java.util.*;

public class Solution {
    /*
一个餐馆，菜单上各种食物价格如下
A， $ X.XX
B， $ Y.YY
C， $ Z.ZZ
D,  $ ...

问现在一个人有 一定数额的钱，比如 $MM.MM，如何点菜才能把钱全部花完？
面试官要求列出所有可能的组合
    * */

    class Dish {
        public Dish(String name, float price) {
            this.name = name;
            this.price = price;
        }

        String name;
        float price;
    }

    public List<List<String>> getPlans(String[] names, float[] prices, float target) {
        List<Dish> menu = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            menu.add(new Dish(names[i], prices[i]));
        }
        Collections.sort(menu, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                if (Math.abs(o1.price - o2.price) < 0.000001) {
                    return 0;
                }
                return o1.price - o2.price > 0.0 ? 1 : -1;
            }
        });
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> order = new LinkedList<>();
        backTracking(menu, 0, target, res, order, 0.0);
        return res;
    }

    private void backTracking(List<Dish> menu, int startDishIndex, float target, List<List<String>> res, LinkedList<String> order, double curBill) {
        if (Math.abs(target - curBill) < 0.000001) {
            res.add(new LinkedList<>(order));
            return;
        }
        if (startDishIndex == menu.size()) {
            return;
        }
        backTracking(menu, startDishIndex + 1, target, res, order, curBill);

        if (menu.get(startDishIndex).price + curBill <= target) {
            order.addLast(menu.get(startDishIndex).name);
            backTracking(menu, startDishIndex, target, res, order, curBill + menu.get(startDishIndex).price);
            order.removeLast();
        }
    }

    public static void main(String[] args) {
        String[] names = new String[] {"A", "B", "C", "D", "E"};
        float[] prices = new float[] {2, 3, 5, 3.2f, 2.8f};
        System.out.println(new Solution().getPlans(names, prices, 9));
    }
}
