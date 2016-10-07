package _68TextJustification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int curLen = 0;
        List<String> buffer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!buffer.isEmpty()) {
                curLen++;
            }
            if (curLen + words[i].length() > maxWidth) {
                res.add(genRow(buffer, curLen - 1, maxWidth));
                buffer.clear();
                curLen = 0;
            }
            curLen += words[i].length();
            buffer.add(words[i]);
            if (i == words.length-1) {
                res.add(genLastRow(buffer, maxWidth));
            }
        }
        return res;
    }

    private String genLastRow(List<String> buffer, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        for (String word : buffer) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(word);
        }
        while (sb.length() < maxWidth) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private String genRow(List<String> buffer, int curLen, int maxWidth) {
        int[] extra = new int[buffer.size()-1];
        int i = 0;
        while (maxWidth != curLen && buffer.size() > 1) {
            i %= (buffer.size()-1);
            extra[i]++;
            curLen++;
            i++;
        }
        StringBuffer sb = new StringBuffer();
        for (i = 0; i < buffer.size(); i++) {
            if (i != 0) {
                sb.append(' ');
            }
            sb.append(buffer.get(i));
            if (i != buffer.size()-1) {
                for (int j = 0; j < extra[i]; j++) {
                    sb.append(' ');
                }
            }
        }
        while (maxWidth != sb.length()) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
