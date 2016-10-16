package CSVParser;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
/*
John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
"""Alexandra Alex"""
John|Smith|john.smith@gmail.com|Los Angeles|1
Jane|Roberts|janer@msn.com|San Francisco, CA|0
Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
"Alexandra Alex"
*/
    public static String parseCSV(String s) {
        StringBuffer res = new StringBuffer();
        int start = 0;
        boolean inQuote = false;
        /**
         * 情况:
         *      当前是否在quote中
         *      如果是:
         *       当前是否是',' 或者是最后一个元素
         *       当前是否是'"'
         *      如果否:
         *       当前是否是'"'
         *      */
        for (int i = 0; i < s.length(); i++) {
            if (!inQuote || i == s.length()-1) {
                if (s.charAt(i) == ',' || i == s.length()-1) {
                    if (res.length() != 0) {
                        res.append('|');
                    }

                    // 如果当前是最后一个元素,直接取当前段开始parse
                    // 如果当前是',',略过这个符号,取前面一段开始parse
                    int end = i == s.length()-1 ? s.length()-1 : i-1;
                    res.append(parseField(s, start, end));
                    start = i+1;
                } else if (s.charAt(i) == '"') {
                    inQuote = !inQuote;
                }
            } else {
                if (s.charAt(i) == '"') {
                    inQuote = !inQuote;
                }
            }
        }
        return res.toString();
    }

    // 1. remove head and tail quote if present
    // 2. reduce double quote if present
    private static String parseField(String s, int start, int cur) {
        if (s.charAt(start) == '"') {
            start++;
            cur--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= cur; i++) {
            if (s.charAt(i) == '"' && i+1 <= cur && s.charAt(i+1) == '"') {
                sb.append('"');
                i++;
            } else {
                sb.append(s.charAt(i));
            }

            // 只保留1个双引号的写法:
            //if (s.charAt(i) == '"' && i-1 >= start && s.charAt(i-1) == '"') {
            //    continue;
            //}
            //sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "John,Smith,john.smith@gmail.com,Los Angeles,1";
        System.out.println(Solution.parseCSV(input1));
        System.out.println(Solution2.parseCSV(input1));
        System.out.println(Solution.parseCSV(input1).equals(Solution2.parseCSV(input1)));

        String input2 = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
        System.out.println(Solution.parseCSV(input2));
        System.out.println(Solution2.parseCSV(input2));
        System.out.println(Solution.parseCSV(input2).equals(Solution2.parseCSV(input2)));

        String input3 = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
        System.out.println(Solution.parseCSV(input3));
        System.out.println(Solution2.parseCSV(input3));
        System.out.println(Solution.parseCSV(input3).equals(Solution2.parseCSV(input3)));

        String input4 = "\"\"\"Alexandra Alex\"\"\"";
        System.out.println(Solution.parseCSV(input4));
        System.out.println(Solution2.parseCSV(input4));
        System.out.println(Solution.parseCSV(input4).equals(Solution2.parseCSV(input4)));

        String input5 = "\"\"\"\"\"\"Alexandra Alex\"\"\"\"\"\"";
        System.out.println(Solution.parseCSV(input5));
        System.out.println(Solution2.parseCSV(input5));
        System.out.println(Solution.parseCSV(input5).equals(Solution2.parseCSV(input5)));
    }
}
