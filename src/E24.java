public class E24 {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public static ListNode swapPairs(ListNode head) {
        ListNode pointer = new ListNode(0, head);
        ListNode res = pointer, holder;
        while (true) {
            if (pointer.next == null || pointer.next.next == null) break;
            holder = pointer.next;
            pointer.next = pointer.next.next;
            holder.next = pointer.next.next;
            pointer.next.next = holder;
            pointer = pointer.next.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        System.out.println(equal(from(new int[]{1, 2, 3}), from(new int[]{1, 2, 3})));
        System.out.println(!equal(from(new int[]{1, 2, 3}), from(new int[]{3, 2, 1})));
        System.out.println(!equal(from(new int[]{1, 2, 3}), from(new int[]{})));
        System.out.println(equal(swapPairs(from(new int[]{1, 2, 3, 4})), from(new int[]{2, 1, 4, 3})));
        System.out.println(equal(swapPairs(from(new int[]{1, 2, 3, 4, 5})), from(new int[]{2, 1, 4, 3, 5})));
        System.out.println(equal(swapPairs(from(new int[]{})), from(new int[]{})));
        System.out.println(equal(swapPairs(from(new int[]{1})), from(new int[]{1})));
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
