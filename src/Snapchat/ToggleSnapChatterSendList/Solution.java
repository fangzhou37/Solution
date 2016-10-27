package Snapchat.ToggleSnapChatterSendList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    static class Node {
        String value;
        Node pre;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    final Node root;
    Node cur;
    Map<String, Node> map;

    public Solution() {
        this.root = new Node(null);
        this.cur = root;
        map = new HashMap<>();
    }

    public void toggle(String username) {
        if (map.containsKey(username)) {
            removeFromList(map.get(username));
            map.remove(username);
        } else {
            Node node = addToList(username);
            map.put(username, node);
        }
    }

    public List<String> getSelectedList()  {
        List<String> res = new LinkedList<>();
        Node cur = root.next;
        while (cur != null) {
            res.add(cur.value);
            cur = cur.next;
        }
        return res;
    }

    private Node addToList(String username) {
        Node node = new Node(username);
        cur.next = node;
        node.pre = cur;
        cur = node;
        return node;
    }

    private void removeFromList(Node node) {
        Node pre = node.pre, next = node.next;
        pre.next = next;
        if (next != null) {
            next.pre = pre;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.toggle("a");
        s.toggle("b");
        s.toggle("c");
        System.out.println(s.getSelectedList());
        s.toggle("b");
        System.out.println(s.getSelectedList());
        s.toggle("b");
        System.out.println(s.getSelectedList());
        s.toggle("c");
        System.out.println(s.getSelectedList());
        s.toggle("a");
        System.out.println(s.getSelectedList());
        s.toggle("b");
        System.out.println(s.getSelectedList());
    }
}
