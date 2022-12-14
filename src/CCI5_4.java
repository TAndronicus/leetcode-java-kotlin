public class CCI5_4 {

    public static int nextNumber(int n) {
        int mask = 3;
        int pattern = 1;
        for (int i = 0; i < 30; i++) {
            if ((n & mask) == pattern) return n + pattern;
            mask = mask << 1;
            pattern = pattern << 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nextNumber(0b11111) == 0b101111);
        System.out.println(nextNumber(0b10111) == 0b11011);
        System.out.println(nextNumber(0b10101) == 0b10110);
        System.out.println(nextNumber(8) == 16);
    }
}
