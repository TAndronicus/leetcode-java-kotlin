public class E26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[counter - 1]) {
                if (i != counter) nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }

    public static boolean sameArrays(int[] a1, int[] a2, int index) {
        for (int i = 0; i < index; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 1, 2};
        int a1l = removeDuplicates(a1);
        System.out.println(a1l == 2);
        System.out.println(sameArrays(new int[]{1, 2}, a1, a1l));
        int[] a2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int a2l = removeDuplicates(a2);
        System.out.println(a2l == 5);
        System.out.println(sameArrays(new int[]{0, 1, 2, 3, 4}, a2, a2l));
        int[] a3 = new int[]{0};
        int a3l = removeDuplicates(a3);
        System.out.println(a3l == 1);
        System.out.println(sameArrays(new int[]{0}, a3, a3l));
        int[] a4 = new int[]{0, 1, 2, 3, 4};
        int a4l = removeDuplicates(a4);
        System.out.println(a4l == 5);
        System.out.println(sameArrays(new int[]{0, 1, 2, 3, 4}, a4, a4l));
    }
}
