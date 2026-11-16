/**
 * Assignment: Stack and Queue (DS-3, Sections A & B)
 * Question 3: Queue Implementation using Array
 *
 * This program implements a linear Queue data structure using an array.
 * Operations supported:
 *  - enqueue(int element) : Insert element at rear (with Overflow check)
 *  - dequeue()            : Remove and return element from front (with Underflow check)
 *  - front()              : View the front element without removing it
 *  - display()            : Print all elements currently in the queue from front to rear
 *  - isEmpty() / isFull() : Helper status checks
 */

public class Q3_Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    // Constructor to initialize the queue with a fixed capacity
    public Q3_Queue(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    // Check if queue is full (Overflow condition)
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Check if queue is empty (Underflow condition)
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    // Enqueue operation: inserts an element at the rear of the queue
    public void enqueue(int element) {
        // Queue Overflow check
        if (isFull()) {
            System.out.println("[Error] Queue Overflow! Cannot enqueue " + element + ". Queue is full.");
            return;
        }

        // When inserting the first element, set front to index 0
        if (front == -1) {
            front = 0;
        }

        rear++;
        arr[rear] = element;
        System.out.println("Enqueued " + element + " to queue.");
    }

    // Dequeue operation: removes and returns the front element
    public int dequeue() {
        // Queue Underflow check
        if (isEmpty()) {
            System.out.println("[Error] Queue Underflow! Queue is empty, nothing to dequeue.");
            return -1;
        }

        int removedValue = arr[front];
        front++;
        System.out.println("Dequeued " + removedValue + " from queue.");

        // If all elements have been removed, reset pointers to initial state
        if (front > rear) {
            front = -1;
            rear = -1;
        }

        return removedValue;
    }

    // Front operation: returns the front element without removing it
    public int front() {
        if (isEmpty()) {
            System.out.println("[Notice] Queue is empty. No front element.");
            return -1;
        }
        return arr[front];
    }

    // Display operation: prints all current elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is currently empty: [ ]");
            return;
        }

        System.out.print("Current Queue (front to rear): ");
        for (int i = front; i <= rear; i++) {
            if (i == front) {
                System.out.print(arr[i] + " (FRONT)");
            } else if (i == rear) {
                System.out.print(" -> " + arr[i] + " (REAR)");
            } else {
                System.out.print(" -> " + arr[i]);
            }
        }
        System.out.println();
    }

    // Main method to demonstrate and test all operations
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("   QUESTION 3: QUEUE IMPLEMENTATION (ARRAY)     ");
        System.out.println("================================================\n");

        // 1. Create a queue of capacity 4
        Q3_Queue queue = new Q3_Queue(4);

        // 2. Test Underflow on empty queue
        System.out.println("--- 1. Testing Underflow Condition ---");
        queue.dequeue();
        queue.front();
        System.out.println();

        // 3. Test Enqueue operations
        System.out.println("--- 2. Testing Enqueue Operations ---");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.display();
        System.out.println("Current Front Element: " + queue.front());
        System.out.println();

        // 4. Test Overflow condition
        System.out.println("--- 3. Testing Overflow Condition ---");
        queue.enqueue(500); // Exceeds capacity 4
        System.out.println();

        // 5. Test Dequeue operations
        System.out.println("--- 4. Testing Dequeue Operations ---");
        queue.dequeue();
        queue.display();
        System.out.println("New Front Element: " + queue.front());
        System.out.println();

        // 6. Empty the queue completely
        System.out.println("--- 5. Emptying the Queue ---");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.display();
        System.out.println();
    }
}
