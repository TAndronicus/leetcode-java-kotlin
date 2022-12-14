import java.util.List;

public interface ST<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    List<Key> getKeys();

}
