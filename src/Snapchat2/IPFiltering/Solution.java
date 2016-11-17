package Snapchat2.IPFiltering;

public class Solution {
    static class Rules {
        String[] rules;
        TrieNode root = new TrieNode();

        public Rules(String[] rules) {
            this.rules = rules;

        }

        class TrieNode {
            TrieNode[] children = new TrieNode[2];
            boolean isLeaf = false;
        }

        // Assume ip rule is in binary
        private void addToTrie(String ipRule) {
            int maskBitNumber = Integer.parseInt(ipRule.split("/")[0]);
            TrieNode cur = root;
            for (int i = 0; i < maskBitNumber; i++) {

            }
        }
    }
}
