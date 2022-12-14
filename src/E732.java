import java.util.TreeMap;

public class E732 {
    static class MyCalendarThree {

        private final TreeMap<Integer, Integer> bookings;

        public MyCalendarThree() {
            bookings = new TreeMap<>();
        }

        public int book(int start, int end) {
            bookings.merge(start, 1, (acc, __) -> acc + 1);
            bookings.merge(end, -1, (acc, __) -> acc - 1);
            int maxBooking = 0, cumsum = 0;
            for (int diff : bookings.values()) {
                cumsum += diff;
                maxBooking = Math.max(maxBooking, cumsum);
            }
            return maxBooking;
        }
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree1 = new MyCalendarThree();
        System.out.println(myCalendarThree1.book(10, 20) == 1);
        System.out.println(myCalendarThree1.book(50, 60) == 1);
        System.out.println(myCalendarThree1.book(10, 40) == 2);
        System.out.println(myCalendarThree1.book(5, 15) == 3);
        System.out.println(myCalendarThree1.book(5, 10) == 3);
        System.out.println(myCalendarThree1.book(25, 55) == 3);
        MyCalendarThree myCalendarThree2 = new MyCalendarThree();
        System.out.println(myCalendarThree2.book(24, 40) == 1);
        System.out.println(myCalendarThree2.book(43, 50) == 1);
        System.out.println(myCalendarThree2.book(27, 43) == 2);
        System.out.println(myCalendarThree2.book(5, 21) == 2);
        System.out.println(myCalendarThree2.book(30, 40) == 3);
        System.out.println(myCalendarThree2.book(14, 29) == 3);
        System.out.println(myCalendarThree2.book(3, 19) == 3);
        System.out.println(myCalendarThree2.book(3, 14) == 3);
        System.out.println(myCalendarThree2.book(25, 39) == 4);
        System.out.println(myCalendarThree2.book(6, 19) == 4);
    }
}
