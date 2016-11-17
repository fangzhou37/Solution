import java.util.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println(Main.paginate(i, 30, 11));
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

        int middleElements = numVisiblePages - 2;
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
        for (Integer i : buffer) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            if (i == currentPage) {
                sb.append('[');
            }
            sb.append(i);
            if (i == currentPage) {
                sb.append(']');
            }
        }
        return sb.toString();
    }}
