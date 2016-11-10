package Snapchat2.WordAbbreviation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public class TriNode {
        TriNode[] children;
        int wordsCnt;
        public TriNode(){
            this.children = new TriNode[26];
            this.wordsCnt = 0;
        }
    }

    public String[] EncodeStr(String[] ipt){
        Map<String, TriNode> map = new HashMap<>();

        //build trie for input string
        for(String ea : ipt){
            int len = ea.length();
            String ptn = ""+ea.charAt(0)+len+ea.charAt(len-1);
            if(!map.containsKey(ptn)){
                TriNode crt = new TriNode();
                map.put(ptn,crt);
            }
            addToTrie(ea,map.get(ptn));
        }

        String[] rst = new String[ipt.length];
        //check for validation and start encoding
        for(int i=0;i<ipt.length;i++){
            int len = ipt[i].length();
            String ptn = ""+ipt[i].charAt(0)+len+ipt[i].charAt(len-1);
            TriNode root = map.get(ptn);
            String prefix = findPrefix(ipt[i],root);
            String abbStr = ""+prefix+len+ipt[i].charAt(len-1);
            rst[i] = abbStr.length()<len ? abbStr : ipt[i];
        }
        return rst;
    }

    private void addToTrie(String s, TriNode root){
        TriNode idx = root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(idx.children[c-'a']==null)
                idx.children[c-'a'] = new TriNode();
            idx = idx.children[c-'a'];
            idx.wordsCnt++;
        }
    }

    private String findPrefix(String s, TriNode root){
        StringBuilder prefix = new StringBuilder();
        TriNode idx = root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            idx = idx.children[c-'a'];
            prefix.append(c);
            if(idx.wordsCnt==1) return prefix.toString();
        }
        return prefix.toString();
    }
//[l4e, god, internal, me, i8t, interval, inte9n, f4e, intr9n]
    public static void main(String[] args) {
        String[] ipt = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        String[] rst = solution.EncodeStr(ipt);
        System.out.println(Arrays.toString(rst));

        String[] rst2 = solution2.abbrev(ipt);
        System.out.println(Arrays.toString(rst2));
    }
}
