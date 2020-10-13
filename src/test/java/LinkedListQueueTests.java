import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTests {
    @Test
    public void testEmptyIntQueue() {
        Queue<Integer> queue = new ListQueue<>();
        assertEquals(0, queue.size());
        assertNull(queue.poll());
        assertNull(queue.peek());
    }

    @Test
    public void testNonEmptyIntQueue() {
        for (int i = 1; i < 10; i++) {
            String caseId = String.format("case %d: ", i);
            Queue<Integer> queue = new ListQueue<>();
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
            assertEquals(0, queue.size());
        }
    }
}
