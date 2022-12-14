import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NumberContainers {

    private final Map<Integer, Integer> indexToValue;
    private final Map<Integer, List<Integer>> valueToIndex;

    public NumberContainers() {
        indexToValue = new HashMap<>();
        valueToIndex = new HashMap<>();
    }

    public void change(int index, int number) {
        if (!indexToValue.containsKey(index)) {
            indexToValue.put(index, number);
            List<Integer> list = new ArrayList<>();
            list.add(index);
            valueToIndex.put(number, list);
        } else {
            Integer existing = indexToValue.get(index);
            if (existing != number) {
                indexToValue.put(index, number);
                valueToIndex.get(existing).removeIf(el -> el == index);
            }
        }
    }

    public int find(int number) {
        List<Integer> indexes = valueToIndex.get(number);
        if (indexes == null) return -1;
        else return indexes.stream().min(Comparator.naturalOrder()).orElse(-1);
    }
}

public class BC83E3 {

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10) == -1);
        nc.change(2, 10);
        nc.change(1, 10);
        nc.change(3, 10);
        nc.change(5, 10);
        System.out.println(nc.find(10) == 1);
        System.out.println(nc.find(10));
        nc.change(1, 5);
        System.out.println(nc.find(10) == 2);
    }
}
