public class E27 {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
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
        int[] a1 = new int[]{3, 2, 2, 3};
        int a1l = removeElement(a1, 3);
        System.out.println(a1l == 2);
        System.out.println(sameArrays(new int[]{2, 2}, a1, a1l));
        int[] a2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int a2l = removeElement(a2, 2);
        System.out.println(a2l == 5);
        System.out.println(sameArrays(new int[]{0, 1, 3, 0, 4}, a2, a2l));
        int[] a3 = new int[]{};
        int a3l = removeElement(a3, 0);
        System.out.println(a3l == 0);
        System.out.println(sameArrays(new int[]{}, a3, a3l));
        int[] a4 = new int[]{0, 1, 2, 3, 4};
        int a4l = removeElement(a4, 5);
        System.out.println(a4l == 5);
        System.out.println(sameArrays(new int[]{0, 1, 2, 3, 4}, a4, a4l));
    }
}
