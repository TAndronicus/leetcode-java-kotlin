public class E9 {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int halfDigits = (int) Math.pow(10, ((int) Math.ceil(Math.log10(x))) / 2);
        return x / halfDigits == x % halfDigits || x / (halfDigits * 10) == x % halfDigits;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
        System.out.println(!isPalindrome2(1212));
        System.out.println(!isPalindrome2(12122));
        System.out.println(isPalindrome2(12121));
        System.out.println(!isPalindrome2(-121));
        System.out.println(!isPalindrome2(10));
    }
}
