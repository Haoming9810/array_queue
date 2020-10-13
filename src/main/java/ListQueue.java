public class ListQueue<T> implements Queue<T> {

    private SingleLinkedList<T> data;

    public ListQueue() {
        data = new SingleLinkedList<>();
    }

    @Override
    public T poll() {
        if (data.size() == 0) {
            return null;
        }
        T val = data.get(0);
        data.removeFirst();
        return val;
    }

    @Override
    public boolean add(T val) {
        data.add(val);
        return true;
    }

    @Override
    public T peek() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }
}
