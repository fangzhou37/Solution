package _385MiniParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty() || s.length() == 0) return new NestedInteger();
        try {
            return new NestedInteger(Integer.valueOf(s));
        } catch (Exception e) {
            // swallow exception
        }
        return deserializeInternal(s);
    }

    private NestedInteger deserializeInternal(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = null;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                if (cur != null) {
                    stack.push(cur);    // Store current work (this level)
                }
                cur = new NestedInteger();  // head of next level
                l = i + 1;
            } else if (s.charAt(i) == ']' || s.charAt(i) == ',') {
                if (l < i) {
                    String subStr = s.substring(l, i);
                    cur.add(new NestedInteger(Integer.valueOf(subStr)));    // Append to this level (end of list)
                }
                if (s.charAt(i) == ']') {
                    if (!stack.isEmpty()) {
                        stack.peek().add(cur);  // Store(append) to upper level
                        cur = stack.pop();    // go to upper level
                    }
                }
                l = i + 1;
            }
        }
        return cur;
    }
}

class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }

    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public String printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            }
            else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
