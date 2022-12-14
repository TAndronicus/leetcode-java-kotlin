public class E8 {

    public static int myAtoi(String s) {
        String stripped = s.stripLeading();
        if (stripped.isEmpty()) return 0;
        int mul = 1;
        if (stripped.charAt(0) == '-') {
            mul = -1;
            stripped = stripped.substring(1);
        } else if (stripped.charAt(0) == '+') {
            stripped = stripped.substring(1);
        }
        int res = 0, pointer = 0;
        for (char c : stripped.toCharArray()) {
            if (!Character.isDigit(c)) break;
            pointer *= 10;
            pointer += (Character.digit(c, 10) * mul);
            if (pointer / 10 != res) return mul == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = pointer;
        }
        return res;
    }

    public static int myAtoi2(String s) {
        int res = 0, pointer = 0, mul = 1;
        for (char c : s.toCharArray()) {
            if (c == ' ' || c == '+') continue;
            if (c == '-') {
                mul = -1;
                continue;
            }
            if (!Character.isDigit(c)) break;
            pointer *= 10;
            pointer += (mul * Character.digit(c, 10));
            if (pointer / 10 != res) return mul == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = pointer;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2("42") == 42);
        System.out.println(myAtoi2("   -42") == -42);
        System.out.println(myAtoi2("42with words") == 42);
        System.out.println(myAtoi2("42with words") == 42);
        System.out.println(myAtoi2(" 2147483647") == 2147483647);
        System.out.println(myAtoi2(" 12147483648") == 2147483647);
        System.out.println(myAtoi2(" -12147483648") == -2147483648);
        System.out.println(myAtoi2(" -121474836480") == -2147483648);
        System.out.println(myAtoi2("") == 0);
        System.out.println(myAtoi2("+1") == 1);
        System.out.println(myAtoi2(" -121474836480"));
    }
}
