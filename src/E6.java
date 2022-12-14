public class E6 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] chars = s.toCharArray();
        int length = chars.length, counter = 0;
        char[] res = new char[length];
        for (int i = 0; i < numRows; i++) {
            int j = i;
            if (i == 0 || i == numRows - 1) {
                while (j < length) {
                    res[counter++] = chars[j];
                    j += (numRows - 1) * 2;
                }
            } else {
                boolean down = true;
                while (j < length) {
                    res[counter++] = chars[j];
                    if (down) {
                        j += ((numRows - 1 - i) * 2);
                    } else {
                        j += i * 2;
                    }
                    down = !down;
                }
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING", 3)));
        System.out.println("A".equals(convert("A", 1)));
        System.out.println("PINALSIGYAHRPI".equals(convert("PAYPALISHIRING", 4)));
    }
}
