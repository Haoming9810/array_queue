import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedListTests {
    @Test
    public void testListWithMultipleElements() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        // list as [-1, 1, 2]
        list.add(1);
        list.add(2);
        list.addFirst(-1);

        System.out.println(list);

        assertEquals(3, list.size());
        assertEquals(-1, list.get(0).intValue());
        assertEquals(1, list.get(1).intValue());
        assertEquals(2, list.get(2).intValue());
        assertNull(list.get(3));

        list.removeLast();

        assertEquals(2, list.size());
        assertEquals(-1, list.get(0).intValue());
        assertEquals(1, list.getLast().intValue());

        list.removeFirst();
        assertEquals(1, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(1, list.getLast().intValue());
    }

    @Test
    public void testEmptyList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        assertEquals(0, list.size());
        assertNull(list.getFirst());
        assertNull(list.getLast());
        assertNull(list.get(0));
    }
}
