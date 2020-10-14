import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueComparison {
    @Test
    public void usingArrayQueue() {
        Queue<Integer> myQueue = new ArrayQueue<>(10);

        myQueue.add(100);
        myQueue.add(200);
        myQueue.add(300);

        assertEquals(100, myQueue.peek().intValue());

        int val = myQueue.poll();

        assertEquals(100, val);

        assertEquals(200, myQueue.peek().intValue());

        assertEquals(2, myQueue.size());
    }

    @Test
    public void usingListQueue() {
        Queue<Integer> myQueue = new ListQueue<>();

        myQueue.add(100);
        myQueue.add(200);
        myQueue.add(300);

        assertEquals(100, myQueue.peek().intValue());

        int val = myQueue.poll();

        assertEquals(100, val);

        assertEquals(200, myQueue.peek().intValue());

        assertEquals(2, myQueue.size());
    }

    @Test
    public void usingBothQueues() {
        Queue<Integer>[] queues = new Queue[500];
        int sizeOfEachQueue = 5;

        for (int i = 0; i < queues.length; i++) {
            if (i % 2 == 0) {
                queues[i] = new ArrayQueue<>(10);
            } else {
                queues[i] = new ListQueue<>();
            }
        }

        for (int i = 0; i < queues.length; i++) {
            for (int j = 0; j < sizeOfEachQueue; j++) {
                queues[i].add(j);
            }
            assertEquals(sizeOfEachQueue, queues[i].size());
        }

        for (int i = 0; i < queues.length; i++) {
            incrementQueueByOne(queues[i]);
        }

        for (int i = 0; i < queues.length; i++) {
            for (int j = 0; j < sizeOfEachQueue; j++) {
                assertEquals(j + 1, queues[i].poll().intValue());
            }
        }
    }

    private void incrementQueueByOne(Queue<Integer> queue) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll() + 1);
        }
    }
}
