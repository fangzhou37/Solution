package SnapchatPhoneAndOnsite.MagicSquare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Solution {
    /*
        testing testing 1 2 3
        breaker breaker

        A magic square is square grid of letters where the rows and the columns both form valid english words.

        Example:

        square = 3x3 grid:
        CAT
        ORE
        TEA

        rows are all english words: CAT, ORE, TEA
        so are the columns: COT, ARE, TEA


        invalid:
        char[][] square = new char[][] {
            new char[] {'A', 'B'},
            null
        };

        char[][] square = new char[][] {
            new char[] {'A', 'B'},
            new char[] {'C'},
        };
    */
    public static boolean isMagicSquare(char[][] square, Collection<String> dictionary) {
        if (square == null || square.length == 0) {
            return true;
        }
        int length = square.length;
        for (char[] row : square) {
            if (row == null || length != row.length) {
                return false;
            }
            String s = new String(row);
            if (!dictionary.contains(s)) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {  // col
            StringBuffer sb = new StringBuffer(length);
            for (char[] row : square) {
                sb.append(row[i]);
            }
            if (!dictionary.contains(sb.toString())) {
                return false;
            }
        }

        return true;
    }


    /**
     * if size = 2 then:
     * AA
     * AA
     * ..
     * XI
     * IN
     * <p>
     * S is size and W is |dictionary|
     * <p>
     * S position
     * Each position W possiblities
     * O(S*W^2)
     * <p>
     * Depth -> size
     * Each level of the tree -> W
     * O(W ^ S * (size * size))
     * <p>
     * [
     * "QUART",
     * "ZEBRA",
     * ]
     */
    public static void printAllMagicSquaresOfSize(int size, Collection<String> dictionary) {
        List<String> cands = new ArrayList<>(dictionary.size());
        for (String word : dictionary) {
            if (word.length() == size) {
                //cand.add(word);
            }
        }

        String[] square = new String[size];
        dfs(square,0, cands);
    }

    private static void dfs(String[] square, int sInd, List<String> cands) {
        if (sInd == square.length) {
            //if (isMagicSquare(square)) {
            //    print(square);
            //}
            return ;
        }

        for (String cand : cands) {
            square[sInd] = cand;
            dfs(square, sInd + 1, cands);
        }
    }
}
