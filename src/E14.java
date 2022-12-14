public class E14 {

    // "" -> 0
    // "f" -> 1

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int length = 0;
        while (true) {
            if (strs[0].length() <= length) return strs[0].substring(0, length);
            char current = strs[0].charAt(length);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= length || current != strs[i].charAt(length)) return strs[0].substring(0, length);
            }
            length++;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl"));
        System.out.println(longestCommonPrefix(new String[]{"", "flow", "flight"}).equals(""));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", ""}).equals(""));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}).equals(""));
    }
}
