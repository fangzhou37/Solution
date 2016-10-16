package CSVParser;

import java.io.*;
import java.util.*;

class Solution {
    public static String parseCSV(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return "";
        }

        boolean inQuote = false;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            if (inQuote) {
                if (s.charAt(i) == '"') {
                    if (i == s.length() - 1) {
                        result.add(sb.toString());
                        return printStr(result);
                    } else if (s.charAt(i + 1) == '"') {
                        sb.append('"');
                        i++;
                    } else {
                        result.add(sb.toString());
                        sb.setLength(0);
                        inQuote = false;
                        i++;
                    }
                } else {
                    sb.append(s.charAt(i));
                }
            } else {
                if (s.charAt(i) == '"') {
                    inQuote = true;
                } else if (s.charAt(i) == ',') {
                    result.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }

        if (sb.length() > 0) {
            result.add(sb.toString());
        }

        return printStr(result);
    }

    private static String printStr(List<String> input) {
        if (input == null || input.size() == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.size(); i++) {
            sb.append(input.get(i));
            if (i == input.size() - 1) {
                break;
            }
            sb.append("|");
        }

        return sb.toString();
    }
}
