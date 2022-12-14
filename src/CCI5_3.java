public class CCI5_3 {

    public static int flipBitToWin(int n) {
        int mask = 1;
        int previousRegion = 0;
        int currentRegion = 0;
        int maxLen = 0;
        boolean previousZero = false;
        for (int i = 0; i < 30; i++) {
            if ((n & mask) == 0) {
                if (previousZero) {
                    previousRegion = 0;
                } else {
                    maxLen = Math.max(maxLen, previousRegion + currentRegion);
                    previousRegion = currentRegion;
                    currentRegion = 0;
                    previousZero = true;
                }
            } else {
                currentRegion++;
                if (previousZero) previousZero = false;
            }
            mask = mask << 1;
        }
        return Math.max(maxLen, previousRegion + currentRegion) + 1;
    }

    public static void main(String[] args) {
        System.out.println(flipBitToWin(0b11011101111) == 8);
        System.out.println(flipBitToWin(0b110111001111) == 6);
        System.out.println(flipBitToWin(0b1100000001) == 3);
    }
}
