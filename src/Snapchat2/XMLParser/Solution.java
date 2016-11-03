package Snapchat2.XMLParser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /*
       <html>
            <user>
                <id>aa</id>
                <meta>bb</meta>
            </user>
       </html>

    得到的token就是
    ("html","open")
    ("user","open")
    ("id","open")
    ("aa","text")
    ("id","close")
    ("meta","open")
    ("bb","text")
    ("meta","close")
    ("user","close")
    ("html","close")
    * */

    static class Token {
        String name;
        String tag; // open/close/text

        public Token(String name, String tag) {
            this.name = name;
            this.tag = tag;
        }
    }

    class Node {
        List<Node> child;
        String Name;

        public Node(String name) {
            Name = name;
            child = new LinkedList<>();
        }

        @Override
        public String toString() {
            if (child == null) {
                return "";
            }
            StringBuffer sb = new StringBuffer();
            if (!child.isEmpty()) {
                for (Node c : child) {
                    sb.append(c);
                    sb.append("\n");
                }
            } else {
                return "<" + Name + ">";
            }

            return "{" + "" + Name + sb.toString() + "}";
        }
    }

    public Token getNextToken() {
        return iter.hasNext() ? iter.next() : null;
    }

    // Given a long string
    String xmlDoc;
    int curPos = 0;
    public Token myGetNextToken() {
        while (curPos < xmlDoc.length() && xmlDoc.charAt(curPos) == ' ') {
            curPos++;
        }
        if (curPos >= xmlDoc.length()) {
            return null;
        }
        if (xmlDoc.charAt(curPos) != '<') {
            // throw new Exception();
        }
        //boolean isClose = ...;
        //for (int i = curPos+1; i < xmlDoc.length(); i++) {
        //    if ()
        //}
        return null;
    }

    public Node buildTree() throws Exception {
        Node cur = null;
        Stack<Node> stack = new Stack<>();
        while (true) {
            Token token = getNextToken();
            if (token == null) {
                break;
            }
            if (token.tag.equals("text")) {
                if (cur == null) {
                    throw new Exception("Malformed xml. Unwrapped tag: " + token.name);
                } else {
                    cur.child.add(new Node(token.name));
                }
            } else if (token.tag.equals("open")) {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new Node(token.name);
            } else if (token.tag.equals("close")) {
                if (cur == null || !cur.Name.equals(token.name)) {
                    // throw exception for unknown tag
                    throw new Exception("Malformed xml. Cannot close: " + token.name);
                }
                if (!stack.isEmpty()) {
                    Node peek = stack.pop();
                    peek.child.add(cur);
                    cur = peek;
                }
            } else {
                throw new Exception("Malformed xml. Unknown tag: " + token.tag);
            }
        }
        return cur;
    }

    static List<Token> xml;
    static Iterator<Token> iter;

    public static void main(String[] args) {
        xml = new LinkedList<>();
        xml.add(new Token("html","open"));
        xml.add(new Token("user","open"));
        xml.add(new Token("id","open"));
        xml.add(new Token("aa","text"));
        xml.add(new Token("id","close"));
        xml.add(new Token("meta","open"));
        xml.add(new Token("bb","text"));
        xml.add(new Token("meta","close"));
        xml.add(new Token("user","close"));
        xml.add(new Token("html","close"));
        iter = xml.iterator();

        Node tree = null;
        try {
            tree = new Solution().buildTree();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(tree);
    }
}
