package _68TextJustification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        List<String> lineBuffer = new ArrayList<>();
        int bufferSize = 0;
        for (int i = 0; i < words.length; i++) {
            if (bufferSize != 0 && bufferSize + 1 + words[i].length() > maxWidth) {
                res.add(align(res, lineBuffer, bufferSize, maxWidth));
                lineBuffer.clear();
                bufferSize = 0;
            }
            lineBuffer.add(words[i]);
            bufferSize += bufferSize == 0 ? 0 : 1;
            bufferSize += words[i].length();
        }

        // 易错点1, 忘记last line
        // Last line
        if (!lineBuffer.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < lineBuffer.size(); i++) {
                if (i != 0) {   // 易错点2, 用sb.length() != 0 来判断是否是第一个元素,如果第一个元素是"",则失效
                    sb.append(' ');
                }
                sb.append(lineBuffer.get(i));
            }
            while (sb.length() < maxWidth) {    // 补齐尾部的空
                sb.append(' ');
            }
            res.add(sb.toString()); // 易错点3,用sb.length() != 0 来判断是否加入res,如果第一个元素是"",则失效
        }
        return res;
    }

    private String align(List<String> res, List<String> lineBuffer, int bufferSize, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        int[] extraSpaces = new int[lineBuffer.size()-1];
        int index = 0;
        while (bufferSize < maxWidth && extraSpaces.length > 0) {
            index %= extraSpaces.length;    // 易错点4,如果只有一个元素,extraSpaces为空,length为0,出现除0错误
            extraSpaces[index++]++;
            bufferSize++;
        }
        for (int i = 0; i < lineBuffer.size(); i++) {
            if (i != 0) {
                sb.append(" ");
                for (int j = 0; extraSpaces.length > 0 && j < extraSpaces[i-1]; j++) {
                    sb.append(" ");
                }
            }
            sb.append(lineBuffer.get(i));
        }
        while (sb.length() < maxWidth) {    // 易错点5,如果只有一个元素,extraSpaces为空无效,这个while开始起作用
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().fullJustify(new String[] {""}, 0);
    }
}
