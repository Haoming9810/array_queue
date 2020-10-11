public class ArrayQueue<T> implements Queue<T> {

    private T[] data;
    private int size;

    // data removed from this side --> [front....end] <-- data added from this side
    private int front;
    private int end;

    private ArrayQueue() {
    }

    public ArrayQueue(int capacity) {
        if (capacity > 0) {
            data = (T[]) new Object[capacity];
            front = 0;
            end = 0;
        }
        size = 0;
    }

    @Override
    public T poll() {
        if (size == 0) {
            return null;
        }
        T val = data[front];
        front = (front + 1) % data.length;
        size--;
        return val;
    }

    @Override
    public boolean add(T val) {
        if (data == null || data.length == 0 || size == data.length) {
            return false;
        }
        data[end] = val;
        end = (end + 1) % data.length;
        size++;
        return true;
    }

    @Override
    public T peak() {
        if (size <= 0) {
            return null;
        }
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }
}
