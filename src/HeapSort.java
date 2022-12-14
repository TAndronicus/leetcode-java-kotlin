import java.util.Arrays;

public class HeapSort {

    public static int left(int index) {
        return 2 * index;
    }

    public static int right(int index) {
        return 2 * index + 1;
    }

    public static int parent(int index) {
        return index / 2;
    }

    public static void swap(int[] a, int i1, int i2) {
        int tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }

    public static void maxHeapify(int[] a, int index, int heapSize) {
        int l = left(index), r = right(index), largest = index;
        if (l < heapSize) largest = (a[l] > a[index]) ? l : index;
        if (r < heapSize) largest = (a[r] > a[largest]) ? r : largest;
        if (largest != index) {
            swap(a, index, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public static int[] toHeap(int... elements) {
        int[] res = new int[elements.length + 1];
        System.arraycopy(elements, 0, res, 1, elements.length);
        return res;
    }

    public static int[] fromHeap(int[] elements) {
        int[] res = new int[elements.length - 1];
        System.arraycopy(elements, 1, res, 0, elements.length - 1);
        return res;
    }

    public static void buildMaxHeap(int[] elements) {
        for (int i = elements.length / 2; i > 0; i--) maxHeapify(elements, i, elements.length);
    }

    public static void heapSort(int[] ar) {
        int heapSize = ar.length;
        buildMaxHeap(ar);
        for (int i = ar.length; i > 1; i--) {
            swap(ar, 1, heapSize - 1);
            heapSize--;
            maxHeapify(ar, 1, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] ar1 = toHeap(0, 6, 5, 5, 4, 3, 2, 1);
        maxHeapify(ar1, 1, ar1.length);
        System.out.println(Arrays.equals(fromHeap(ar1), new int[]{6, 5, 5, 1, 4, 3, 2, 0}));
        int[] ar2 = toHeap(1, 8, 2, 7, 3, 4, 6, 5, 0, 9);
        buildMaxHeap(ar2);
        System.out.println(Arrays.equals(fromHeap(ar2), new int[]{9, 8, 6, 7, 3, 4, 2, 5, 0, 1}));
        int[] ar3 = toHeap(1, 5, 2, 7, 4, 3, 9, 8, 6, 0);
        heapSort(ar3);
        System.out.println(Arrays.equals(fromHeap(ar3), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
