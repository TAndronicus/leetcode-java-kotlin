public class E13 {

    public static int romanToInt(String s) {
        int[] parts = new int[s.length()];
        int counter = 0;
        for (char c : s.toCharArray()) {
            parts[counter] = toRomanChar(c);
            counter++;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && parts[i] < parts[i + 1]) res -= parts[i];
            else res += parts[i];
        }
        return res;
    }

    public static int romanToInt2(String s) {
        int previous = toRomanChar(s.charAt(0)), current = previous, res = 0;
        for (char c : s.substring(1).toCharArray()) {
            current = toRomanChar(c);
            if (previous < current) res -= previous;
            else res += previous;
            previous = current;
        }
        return res + current;
    }

    public static int toRomanChar(char c) {
        if (c == 'M') return 1000;
        else if (c == 'D') return 500;
        else if (c == 'C') return 100;
        else if (c == 'L') return 50;
        else if (c == 'X') return 10;
        else if (c == 'V') return 5;
        else return 1;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt2("III") == 3);
        System.out.println(romanToInt2("D") == 500);
        System.out.println(romanToInt2("LVIII") == 58);
        System.out.println(romanToInt2("MCMXCIV") == 1994);
    }
}
