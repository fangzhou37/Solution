package Snapchat2.ThreeOperationCalculation;

public class TreeNode {
    Boolean val;
    TreeNode judge;
    TreeNode left;
    TreeNode right;

    TreeNode(Boolean x) {
        val = x;
    }

    TreeNode() {}

    public Boolean calculate() {
        if (judge != null) {
            val = judge.calculate() ? left.calculate() : right.calculate();
        }
        return val;
    }
}