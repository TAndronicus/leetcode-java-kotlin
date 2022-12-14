public class E7 {

    public static int reverse(int x) {
        int res = 0;
        boolean neg = false;
        if (x == -2147483648) return 0;
        if (x < 0) {
            x = -x;
            neg = true;
        }
        while (x > 0) {
            if (gonnaOverflow(res, x % 10)) return 0;
            res *= 10;
            res += (x % 10);
            x /= 10;
        }
        return neg ? -res : res;
    }

    public static boolean gonnaOverflow(int res, int mod) {
        return res > 214748364 || (res == 214748364 && mod >= 8);
    }

    public static int reverse2(int x) {
        int res = 0, pointer = 0;
        boolean neg = false;
        if (x == -2147483648) return 0;
        if (x < 0) {
            x = -x;
            neg = true;
        }
        while (x > 0) {
            pointer *= 10;
            pointer += (x % 10);
            if (pointer / 10 != res) return 0;
            res = pointer;
            x /= 10;
        }
        return neg ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123) == 321);
        System.out.println(reverse(-123) == -321);
        System.out.println(reverse(2147483647) == 0);
        System.out.println(reverse(1534236469) == 0);
        System.out.println(reverse(120) == 21);
        System.out.println(reverse2(123) == 321);
        System.out.println(reverse2(-123) == -321);
        System.out.println(reverse2(2147483647) == 0);
        System.out.println(reverse2(1534236469) == 0);
        System.out.println(reverse2(120) == 21);
    }
}
