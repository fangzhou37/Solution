package _297SerializeAndDeserializeBinaryTree;

class Codec {
    public static final String DELIMITOR = ",";
    public static final String NULL = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeHeler(sb, root);
        return sb.toString();
    }

    private void serializeHeler(StringBuffer sb, TreeNode root) {
        if (sb.length() != 0) {
            sb.append(DELIMITOR);
        }
        if (root == null) {
            sb.append(NULL);
            return;
        }
        sb.append(root.val);
        serializeHeler(sb, root.left);
        serializeHeler(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] seg = data.split(DELIMITOR);
        if (seg.length == 0 || seg[0].equals(NULL)) {
            return null;
        }
        int[] curInd = new int[1];
        curInd[0] = 0;
        return deserializeHelper(seg, curInd);
    }

    private TreeNode deserializeHelper(String[] seg, int[] curInd) {
        if (curInd[0] >= seg.length) {
            return null;
        }
        if (seg[curInd[0]].equals(NULL)) {
            curInd[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(seg[curInd[0]]));
        curInd[0]++;
        cur.left = deserializeHelper(seg, curInd);
        cur.right = deserializeHelper(seg, curInd);
        return cur;
    }
}

public class Solution {
}
