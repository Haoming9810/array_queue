import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testEmptyQueue() {
        ArrayQueue queue = new ArrayQueue(0);
        assertEquals(0, queue.size());
        assertNull(queue.poll());
        assertNull(queue.peak());

        queue = new ArrayQueue(-1);
        assertEquals(0, queue.size());
        assertNull(queue.peak());
    }

    @Test
    public void testNonEmptyQueueWithinCapacity() {
        for (int i = 1; i < 10; i++) {
            String caseId = String.format("case %d: ", i);
            ArrayQueue queue = new ArrayQueue(i);
            assertEquals(caseId, 0, queue.size());
            assertNull(caseId, queue.poll());

            // test filling up
            for (int j = 0; j < i; j++) {
                assertTrue(caseId, queue.add(j));
                assertEquals(caseId, j + 1, queue.size());
                assertNotNull(caseId, queue.peak());
                assertEquals(caseId, 0, queue.peak().intValue());
            }

            // test emptying
            for (int j = 0; j < i; j++) {
                Integer val = queue.poll();
                assertNotNull(val);
                assertEquals(j, val.intValue());
                if (queue.size()>0) {
                    assertEquals(j + 1, queue.peak().intValue());
                }
            }
        }
    }

    @Test
    public void testQueueExceedingCapacity() {
        ArrayQueue queue = new ArrayQueue(3);
        for (int j = 0; j < 3; j++) {
            queue.add(j);
        }

        // queue full, add should fail
        assertFalse(queue.add(3));

        // pop one element
        queue.poll();

        // now add can succeed
        assertTrue(queue.add(3));
        assertEquals(1, queue.peak().intValue());
    }
}
