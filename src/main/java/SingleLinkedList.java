public class SingleLinkedList<T> implements List<T> {
    private ListNode<T> head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode<T>();  // life is too short for not using a dummy node
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    // Returns the element at the specified position in this list
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode<T> ptr = head.next;
        for (int i = 0; i < index; i++) {
            if (ptr == null) {
                return null;
            }
            ptr = ptr.next;
        }
        return ptr.val;
    }

    // Appends the specified element to the end of this list
    @Override
    public void add(T val) {
        size++;
        ListNode<T> ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode<T>(val);
    }

    // Inserts the specified element at the beginning of this list
    @Override
    public void addFirst(T val) {
        size++;
        ListNode<T> newNode = new ListNode<T>(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    // Removes and returns the first element from this list
    @Override
    public void removeFirst() {
        if (head.next == null) {
            return;
        }
        head.next = head.next.next;
        size--;
    }

    // Removes and returns the last element from this list
    @Override
    public void removeLast() {
        if (head.next == null) {
            return;
        }
        size--;

        ListNode<T> p1 = head;
        ListNode<T> p2 = head.next;

        while (p2.next != null) {
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode<T> ptr = head.next;
        do {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        } while (ptr != null);
        return builder.toString();
    }
}
