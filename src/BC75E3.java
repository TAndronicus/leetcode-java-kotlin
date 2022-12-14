import java.util.Deque;
import java.util.LinkedList;

public class BC75E3 {

    public static long numberOfWays1(String s) {
        long sum = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) continue;
                for (int k = j + 1; k < s.length(); k++) {
                    if (s.charAt(j) == s.charAt(k)) continue;
                    sum++;
                }
            }
        }
        return sum;
    }

    public static long numberOfWays2(String s) {
        int currentCount = 1;
        char currentChar = s.charAt(0);
        Deque<Integer> integers = new LinkedList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                currentCount++;
            } else {
                currentChar = s.charAt(i);
                integers.add(currentCount);
                currentCount = 1;
            }
        }
        integers.add(currentCount);
        int[] res = new int[integers.size()];
        int counter = 0;
        while (!integers.isEmpty()) {
            res[counter] = integers.removeFirst();
            counter++;
        }
        if (res.length < 3) return 0L;
        long sum = 0L;
        for (int i = 0; i < res.length - 2; i++) {
            for (int j = i + 1; j < res.length - 1; j += 2) {
                for (int k = j + 1; k < res.length; k += 2) {
                    sum += (long) res[i] * res[j] * res[k];
                }
            }
        }
        return sum;
    }

    public static long numberOfWays3(String s) {
        int currentCount = 1, counter = 0;
        char currentChar = s.charAt(0);
        int[] res = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                currentCount++;
            } else {
                currentChar = s.charAt(i);
                res[counter] = currentCount;
                counter++;
                currentCount = 1;
            }
        }
        res[counter] = currentCount;
        if (counter < 2) return 0L;
        long sum = 0L;
        for (int i = 0; i < counter - 1; i++) {
            for (int j = i + 1; j < counter; j += 2) {
                for (int k = j + 1; k < counter + 1; k += 2) {
                    sum += (long) res[i] * res[j] * res[k];
                }
            }
        }
        return sum;
    }

    public static long numberOfWays4(String s) {
        int c0 = 0, c1 = 0, c01 = 0, c10 = 0, c010 = 0, c101 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                c0++;
                c10 += c1;
                c010 += c01;
            } else {
                c1++;
                c01 += c0;
                c101 += c10;
            }
        }
        return c101 + c010;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays4("001101") == 6L);
        System.out.println(numberOfWays4("11100") == 0L);
    }
}
