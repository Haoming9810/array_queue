public interface List<T> {
    int size();

    T getFirst();

    T getLast();

    T get(int index);

    void add(T val);

    void addFirst(T val);

    void removeFirst();

    void removeLast();
}
