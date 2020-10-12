public interface Queue<T> {

    boolean add(T val);

    T poll();

    T peek();

    int size();
}
