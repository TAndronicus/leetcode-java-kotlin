import java.util.Map;

public class E12 {

    static class Roman {
        char unit;
        char half;
        char max;

        public Roman(char unit, char half, char max) {
            this.unit = unit;
            this.half = half;
            this.max = max;
        }
    }

    static Map<Integer, Roman> romans = Map.of(
            1, new Roman('I', 'V', 'X'),
            10, new Roman('X', 'L', 'C'),
            100, new Roman('C', 'D', 'M'),
            1000, new Roman('M', '?', '?')
    );

    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int order = 1;
        while (num > 0) {
            res = toRomanChar(num % 10, order).append(res);
            num /= 10;
            order *= 10;
        }
        return res.toString();
    }

    public static StringBuilder toRomanChar(int i, int order) {
        StringBuilder res = new StringBuilder();
        if (i == 0) return res;
        if (i % 5 == 4) {
            res.append(romans.get(order).unit);
            i++;
        }
        if (i % 5 == 0) {
            return res.append(i == 5 ? romans.get(order).half : romans.get(order).max);
        }
        if (i > 5) res.append(romans.get(order).half);
        return res.append(repeat(romans.get(order).unit, i % 5));
    }

    public static String repeat(char c, int repetitions) {
        char[] res = new char[repetitions];
        for (int i = 0; i < repetitions; i++) res[i] = c;
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println("III".equals(intToRoman(3)));
        System.out.println("LVIII".equals(intToRoman(58)));
        System.out.println("MCMXCIV".equals(intToRoman(1994)));
        System.out.println("I".equals(intToRoman(1)));
        System.out.println("MMMCMXCIX".equals(intToRoman(3999)));
        System.out.println(intToRoman(10));
    }
}
