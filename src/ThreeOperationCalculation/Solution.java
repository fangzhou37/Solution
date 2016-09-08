package ThreeOperationCalculation;

public class Solution {
    public boolean cal(String expr) {
        if (expr == null || expr.isEmpty()) {
            return false;
        }
        Boolean firstElement = expr.charAt(0) == 'T' ? true : false;
        TreeNode head = new TreeNode(firstElement);
        TreeNode res = parseAndCalculate(expr, 1, head, 1);
        return res.calculate();
    }


    // status == 0, should assign judge, status == 1, should assign left, status == 2 should assign right
    private TreeNode parseAndCalculate(String expr, int i, TreeNode parent, int status) {
        if (i >= expr.length()) {
            return new TreeNode(parent.calculate());
        }

        char cur = expr.charAt(i);
        if (cur == 'T' || cur == 'F') {
            TreeNode n = new TreeNode(cur == 'T' ? true : false);
            if (status == 0) {
                parent.judge = n;
                return parseAndCalculate(expr, i+1, parent, 1);
            } else if (status == 1) {
                parent.left = n;
                return parseAndCalculate(expr, i+1, parent, 2);
            } else {
                parent.right = n;
                TreeNode newStart = new TreeNode(parent.calculate());
                return parseAndCalculate(expr, i+1, newStart, 0);
            }
        } else if (cur == '?'){
            return parseAndCalculate(expr, i+1, parent, 1);
        } else {
            return parseAndCalculate(expr, i+1, parent, status);
        }
    }

    public static void main(String[] args) {
        String s = "T ? T : F ? T ? T : F : F ? F : T";
        Boolean res = new Solution().cal(s);
        System.out.println(res);
    }
}
