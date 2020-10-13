import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTests {
    @Test
    public void testEmptyIntQueue() {
        Queue<Integer> queue = new ArrayQueue<>(0);
        assertEquals(0, queue.size());
        assertNull(queue.poll());
        assertNull(queue.peek());

        queue = new ArrayQueue<>(-1);
        assertEquals(0, queue.size());
        assertNull(queue.peek());
    }

    @Test
    public void testNonEmptyIntQueueWithinCapacity() {
        for (int i = 1; i < 10; i++) {
            String caseId = String.format("case %d: ", i);
            Queue<Integer> queue = new ArrayQueue<>(i);
            assertEquals(caseId, 0, queue.size());
            assertNull(caseId, queue.poll());

            // test filling up
            for (int j = 0; j < i; j++) {
                assertTrue(caseId, queue.add(j));
                assertEquals(caseId, j + 1, queue.size());
                assertNotNull(caseId, queue.peek());
                assertEquals(caseId, (Integer) 0, queue.peek());
            }

            // test emptying
            for (int j = 0; j < i; j++) {
                Integer val = queue.poll();
                assertNotNull(val);
                assertEquals(j, val.intValue());
                if (queue.size() > 0) {
                    assertEquals(j + 1, queue.peek().intValue());
                }
            }
        }
    }

    @Test
    public void testIntQueueExceedingCapacity() {
        Queue<Integer> queue = new ArrayQueue<>(3);
        for (int j = 0; j < 3; j++) {
            queue.add(j);
        }

        // queue full, add should fail
        assertFalse(queue.add(3));

        // pop one element
        queue.poll();

        // now add can succeed
        assertTrue(queue.add(3));
        assertEquals(1, queue.peek().intValue());
    }

    @Test
    public void testStringQueueExceedingCapacity() {
        Queue<String> queue = new ArrayQueue<>(4);
        for (int j = 0; j < 4; j++) {
            queue.add(String.valueOf(j));
        }

        // queue full, add should fail
        String newVal = String.valueOf(99);
        assertFalse(queue.add(newVal));

        // pop one element
        queue.poll();

        // now add can succeed
        assertTrue(queue.add(newVal));
        assertEquals(String.valueOf(1), queue.peek());
    }
}
