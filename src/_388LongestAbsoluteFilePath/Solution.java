package _388LongestAbsoluteFilePath;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /*
    The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

    dir
        subdir1
        subdir2
            file.ext

    */
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for (int i = 0; i < paths.length; i++) {
            int level = paths[i].lastIndexOf('\t')+1;
            int curLength = paths[i].length() - level;
            stack[level] = curLength;
            if (level != 0) {
                stack[level] += stack[level-1];
                stack[level]++; // add '/' between levels
            }
            if (paths[i].indexOf('.') != -1) {	// has to be a file to count file path length
                maxLen = Math.max(maxLen, stack[level]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
