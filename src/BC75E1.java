import java.util.Arrays;

public class BC75E1 {
    public static int minBitFlips(int start, int goal) {
        String startStr = Integer.toBinaryString(start), goalStr = Integer.toBinaryString(goal);
        int flips = 0;
        if (startStr.length() > goalStr.length()) {
            int moves = startStr.length() - goalStr.length();
            flips += Arrays.stream(startStr.substring(0, moves).split("")).mapToInt(Integer::valueOf).sum();
            startStr = startStr.substring(moves);
        } else if (startStr.length() < goalStr.length()) {
            int moves = goalStr.length() - startStr.length();
            flips += Arrays.stream(goalStr.substring(0, moves).split("")).mapToInt(Integer::valueOf).sum();
            goalStr = goalStr.substring(moves);
        }
        for (int i = 0; i < goalStr.length(); i++) {
            if (goalStr.charAt(i) != startStr.charAt(i)) flips++;
        }
        return flips;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7) == 3);
        System.out.println(minBitFlips(3, 4) == 3);
        System.out.println(minBitFlips(10, 82) == 3);
    }
}
