public class BC66E2 {
    public static int numBuckets(String street) {
        if (street.length() == 1) return ".".equals(street) ? 0 : -1;
        if (street.equals("H.") || street.equals(".H")) return 1;
        if (street.equals("..")) return 0;
        if (street.equals("HH")) return -1;
        char[] characters = street.toCharArray();
        int buckets = 0;
        for (int i = 1; i < characters.length - 1; i++) {
            if (characters[i - 1] == 'H' && characters[i] == '.' && characters[i + 1] == 'H') {
                characters[i - 1] = 'D';
                characters[i] = 'B';
                characters[i + 1] = 'D';
                buckets++;
            }
        }
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == 'H' && characters[i + 1] == '.') {
                characters[i] = 'D';
                characters[i + 1] = 'B';
                buckets++;
            } else if (characters[i] == '.' && characters[i + 1] == 'H') {
                characters[i] = 'B';
                characters[i + 1] = 'D';
                buckets++;
            }
        }
        for (char c : characters) if (c == 'H') return -1;
        return buckets;
    }

    public static void main(String[] args) {
        System.out.println(numBuckets(".") == 0);
        System.out.println(numBuckets("H") == -1);
        System.out.println(numBuckets("HH") == -1);
        System.out.println(numBuckets("H.") == 1);
        System.out.println(numBuckets(".H") == 1);
        System.out.println(numBuckets("..") == 0);
        System.out.println(numBuckets("H.H") == 1);
        System.out.println(numBuckets("H..H") == 2);
        System.out.println(numBuckets("H.H.H") == 2);
        System.out.println(numBuckets("H.H.H.") == 2);
        System.out.println(numBuckets(".H.H.H.") == 2);
        System.out.println(numBuckets(".H.HH.H.") == 2);
        System.out.println(numBuckets(".H.H.H.H.") == 2);
        System.out.println(numBuckets(".H......H.") == 2);
        System.out.println(numBuckets(".H.HHH.H.") == -1);
    }
}
