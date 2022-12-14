import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WC270E2 {

    static class ListNode {
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

    public static ListNode deleteMiddle(ListNode head) {
        int length = findLength(head);
        if (length < 2) return head.next;
        int counter = 0;
        ListNode mid = head;
        while (counter != length / 2 - 1) {
            counter++;
            mid = mid.next;
        }
        mid.next = mid.next.next;
        return head;
    }

    public static int findLength(ListNode head) {
        int counter = 1;
        while (head.next != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(toArray(deleteMiddle(fromArray(new int[]{1, 3, 4, 7, 1, 2, 6})))));
        System.out.println(Arrays.equals(toArray(deleteMiddle(fromArray(new int[]{1, 3, 4, 7, 1, 2, 6}))), new int[]{1, 3, 4, 1, 2, 6}));
        System.out.println(Arrays.equals(toArray(deleteMiddle(fromArray(new int[]{1, 2, 3, 4}))), new int[]{1, 2, 4}));
        System.out.println(Arrays.equals(toArray(deleteMiddle(fromArray(new int[]{2, 1}))), new int[]{2}));
    }

    public static int[] toArray(ListNode listNode) {
        List<Integer> integers = new LinkedList<>();
        integers.add(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            integers.add(listNode.val);
        }
        return integers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static ListNode fromArray(int[] array) {
        ListNode result = new ListNode(array[0]);
        ListNode tracker = result;
        for (int i = 1; i < array.length; i++) {
            tracker.next = new ListNode(array[i]);
            tracker = tracker.next;
        }
        return result;
    }
}
