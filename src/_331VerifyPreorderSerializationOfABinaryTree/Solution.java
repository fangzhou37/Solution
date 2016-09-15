package _331VerifyPreorderSerializationOfABinaryTree;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        if (arr.length == 0) {
            return true;
        }
        int open = arr[0].equals("#") ? 0 : 2;
        for (int i = 1; i < arr.length; i++) {
            if (open == 0) {
                return false;
            }
            if (arr[i].equals("#")) {
                open--;
            } else {
                open++;
            }
        }
        return open == 0;
    }
}
