public class E21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(), l1 = new ListNode(0, list1), l2 = new ListNode(0, list2);
        ListNode pointer = sentinel;
        while (l1.next != null || l2.next != null) {
            if (l1.next == null || (l2.next != null && l2.next.val < l1.next.val)) {
                pointer.next = new ListNode(l2.next.val);
                l2.next = l2.next.next;
            } else {
                pointer.next = new ListNode(l1.next.val);
                l1.next = l1.next.next;
            }
            pointer = pointer.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        System.out.println(equal(from(new int[]{1, 2, 3}), from(new int[]{1, 2, 3})));
        System.out.println(!equal(from(new int[]{1, 2, 3}), from(new int[]{3, 2, 1})));
        System.out.println(!equal(from(new int[]{1, 2, 3}), from(new int[]{})));
        System.out.println(equal(mergeTwoLists(from(new int[]{1, 2, 4}), from(new int[]{1, 3, 4})), from(new int[]{1, 1, 2, 3, 4, 4})));
        System.out.println(equal(mergeTwoLists(from(new int[]{}), from(new int[]{})), from(new int[]{})));
        System.out.println(equal(mergeTwoLists(from(new int[]{}), from(new int[]{0})), from(new int[]{0})));
    }

    public static ListNode from(int[] ints) {
        ListNode sentinel = new ListNode();
        ListNode pointer = sentinel;
        for (int i : ints) {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }
        return sentinel.next;
    }

    public static boolean equal(ListNode left, ListNode right) {
        ListNode l1 = new ListNode(0, left), l2 = new ListNode(0, right);
        while (l1.next != null || l2.next != null) {
            if (l1.next == null || l2.next == null) return false;
            if (l1.next.val != l2.next.val) return false;
            l1.next = l1.next.next;
            l2.next = l2.next.next;
        }
        return true;
    }

}
