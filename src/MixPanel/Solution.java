package MixPanel;

import java.util.*;

/*
Write a method that returns a string representing the state of a pagination nav bar

# rule 1: the number of pages returned should match the value of the "numVisiblePages" parameter
# rule 2: always show the first page
# rule 3: always show the last page
# rule 4: put ellipses where appropriate
# rule 5: place [] around the selected page and, if possible, center it

current_page = 5
total_pages = 20

< back | 5 | next >
<< first | < back | 5 | next > | last >>

1 2 3 4 [5] 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20

*/

class Solution {
    public static void main(String[] args) {
        for(int i = 1; i <= 30; i++) {
            System.out.println(Solution.paginate(i, 30, 11));
        }
    }

    private static String paginate(int currentPage, int totalPages, int numVisiblePages) {
        LinkedList<Integer> buffer = new LinkedList<>();
        // current page == 1,  numVisiblePages = 3
        // -2,-1,0,[1],2,3,4
        buffer.add(currentPage);
        for (int i = 1; i <= numVisiblePages; i++) {
            buffer.add(currentPage - i);
            buffer.add(currentPage + i);
        }
        Collections.sort(buffer);
        while (buffer.getFirst() < 1) {
            buffer.removeFirst();
        }
        while (buffer.getLast() > totalPages) {
            buffer.removeLast();
        }

        if (buffer.getFirst() != 1) {
            buffer.addFirst(1);
        }
        if (buffer.getLast() != totalPages) {
            buffer.addLast(totalPages);
        }

        int middleElements = numVisiblePages;
        int currentSize = buffer.size();
        int needToCut = currentSize - middleElements;
        while (needToCut > 0) {
            cut(buffer, currentPage);
            needToCut--;
        }
        return addEllip(buffer, currentPage);
    }

    public static void cut(LinkedList<Integer> buffer, int currentPage) {
        // 1 2 [3] 4 5 6  before => 2   after => 3 = 6 - 2 - 1
        int indexOfCurrentPage = Collections.binarySearch(buffer, currentPage);
        int before = indexOfCurrentPage;
        int after = buffer.size() - indexOfCurrentPage - 1;

        if (before > after) {
            if (indexOfCurrentPage != 1) {
                buffer.remove(1);
            }
        } else {
            if (indexOfCurrentPage != buffer.size()-2) {
                buffer.remove(buffer.size()-2);
            }
        }
    }

    public static String addEllip(LinkedList<Integer> buffer, int currentPage) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buffer.size(); i++) {
            Integer num = buffer.get(i);
            if (sb.length() != 0) {
                sb.append(' ');
            }
            if (sb.length() != 0 && i != 0 && buffer.get(i-1) != buffer.get(i) - 1) {
                sb.append("...");
                sb.append(' ');
            }
            if (num == currentPage) {
                sb.append('[');
            }
            sb.append(num);
            if (num == currentPage) {
                sb.append(']');
            }
        }
        return sb.toString();
    }
}

/*
paginate(1, 30, 11) == "[1] 2 3 4 5 6 7 8 9 10 ... 30"
paginate(5, 30, 11) == "1 2 3 4 [5] 6 7 8 9 10 ... 30"
paginate(10, 30, 11) == "1 ... 6 7 8 9 [10] 11 12 13 14 ... 30"
paginate(24, 30, 11) == "1 ... 20 21 22 23 [24] 25 26 27 28 ... 30"
paginate(30, 30, 11) == "1 ... 21 22 23 24 25 26 27 28 29 [30]"
*/