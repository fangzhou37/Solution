package CSVParser;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public static List<String> parseCSV(String s) {
        //[['John', 'Smith', 'john.smith@gmail.com', 'Los Angeles', '1'],
        // ['Jane', 'Roberts', 'janer@msn.com', 'San Francisco, CA', '0'],
        //['Alexandra "Alex"', 'Menendez', 'alex.menendez@gmail.com', 'Miami', '1']]
        // ->
        // John|Smith|john.smith@gmail.com|Los Angeles|1
        // Jane|Roberts|janer@msn.com|San Francisco, CA|0
        // Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
        List<String> res = new LinkedList<>();
        if (s.length() < 2) {
            return res;
        }
        boolean inQuote = false;
        int start = 1;
        for (int i = 1; i < s.length()-1; i++) {    // ignore head '[' and tail ']'
            if (!inQuote) {
                if (s.charAt(i) == '[') {
                    start = i+1;
                } else if (s.charAt(i) == ']') {
                    res.add(parseCSVLine(s.substring(start, i)));
                    start = i+1;
                }
            } else {
                if (s.charAt(i) == '\'') {
                    inQuote = !inQuote;
                }
            }
        }
        return res;
    }

    public static String parseCSVLine(String s) {
        StringBuffer res = new StringBuffer();
        int start = 0;
        boolean inQuote = false;
        /**
         * 情况:
         *      当前是否在quote中
         *      如果是:
         *       当前是否是',' 或者是最后一个元素
         *       当前是否是'\''
         *      如果否:
         *       当前是否是'\''
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
                    start = i+2;    // jump over comma and space
                } else if (s.charAt(i) == '\'') {
                    inQuote = !inQuote;
                }
            } else {
                if (s.charAt(i) == '\'') {
                    inQuote = !inQuote;
                }
            }
        }
        return res.toString();
    }

    // 1. remove head and tail quote if present
    // 2. reduce double quote if present
    private static String parseField(String s, int start, int cur) {
        if (s.charAt(start) == '\'') {
            start++;
            cur--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= cur; i++) {
            if (s.charAt(i) == '"' && i+1 <= cur && s.charAt(i+1) == '"') {
                sb.append('"');
                i++;
            } else if (s.charAt(i) == '\'' && i+1 <= cur && s.charAt(i+1) == '\'') {
                sb.append('\'');
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
        // John|Smith|john.smith@gmail.com|Los Angeles|1
        // Jane|Roberts|janer@msn.com|San Francisco, CA|0
        // Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
        String input = "[['John', 'Smith', 'john.smith@gmail.com', 'Los Angeles', '1']," +
                "['Jane', 'Roberts', 'janer@msn.com', 'San Francisco, CA', '0']," +
                "['Alexandra \'\'\"\"Alex\"\"\'\'', 'Menendez', 'alex.menendez@gmail.com', 'Miami', '1']]";
        System.out.println(parseCSV(input));
    }
}
