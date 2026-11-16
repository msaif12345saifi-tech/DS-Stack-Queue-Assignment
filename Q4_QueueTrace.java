/**
 * Assignment: Stack and Queue (DS-3, Sections A & B)
 * Question 4: Step-by-Step Queue Operation Simulation
 *
 * Sequence of operations:
 *   1. Enqueue(10)
 *   2. Enqueue(20)
 *   3. Enqueue(30)
 *   4. Dequeue()
 *   5. Enqueue(40)
 *   6. Dequeue()
 *
 * This program runs the exact sequence and displays the state of the queue,
 * the front element, and the rear element after every single operation.
 */

public class Q4_QueueTrace {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public Q4_QueueTrace(int size) {
        this.capacity = size;
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int element) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow!");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear++;
        queue[rear] = element;
    }

    public int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int removed = queue[front];
        front++;
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return removed;
    }

    public int getFront() {
        if (front == -1 || front > rear) return -1;
        return queue[front];
    }

    // Print queue contents clearly from front to rear
    public void printQueueState() {
        if (front == -1 || front > rear) {
            System.out.println("    Queue State: [ EMPTY ]");
            System.out.println("    Front Element: None\n");
            return;
        }

        System.out.print("    Queue State (Front to Rear): [ ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]);
            if (i < rear) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
        System.out.println("    Front Element: " + queue[front]);
        System.out.println("    Rear Element : " + queue[rear]);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("    QUESTION 4: TRACE OF QUEUE OPERATIONS (STEP-BY-STEP)");
        System.out.println("========================================================\n");

        Q4_QueueTrace q = new Q4_QueueTrace(10);

        System.out.println("Initial State: Initially Empty Queue");
        q.printQueueState();

        // Step 1: Enqueue(10)
        System.out.println("Step 1: Execute Enqueue(10)");
        q.enqueue(10);
        q.printQueueState();

        // Step 2: Enqueue(20)
        System.out.println("Step 2: Execute Enqueue(20)");
        q.enqueue(20);
        q.printQueueState();

        // Step 3: Enqueue(30)
        System.out.println("Step 3: Execute Enqueue(30)");
        q.enqueue(30);
        q.printQueueState();

        // Step 4: Dequeue()
        System.out.println("Step 4: Execute Dequeue()");
        int removed1 = q.dequeue();
        System.out.println("    Dequeued Value: " + removed1);
        q.printQueueState();

        // Step 5: Enqueue(40)
        System.out.println("Step 5: Execute Enqueue(40)");
        q.enqueue(40);
        q.printQueueState();

        // Step 6: Dequeue()
        System.out.println("Step 6: Execute Dequeue()");
        int removed2 = q.dequeue();
        System.out.println("    Dequeued Value: " + removed2);
        q.printQueueState();

        // Final Summary
        System.out.println("========================================================");
        System.out.println("                    FINAL RESULT                        ");
        System.out.println("========================================================");
        System.out.println("Final Contents of the Queue (Front to Rear): [ 30, 40 ]");
        System.out.println("Front Element of the Queue                 : " + q.getFront());
        System.out.println("========================================================");
    }
}
