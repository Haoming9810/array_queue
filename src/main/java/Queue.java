public interface Queue<T> {

    boolean add(T val);

    T poll();

    T peak();

    int size();
}
