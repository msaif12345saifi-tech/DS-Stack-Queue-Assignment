/**
 * Assignment: Stack and Queue (DS-3, Sections A & B)
 * Question 1: Stack Implementation using Array
 *
 * This program implements a Stack data structure using a fixed-size array.
 * Operations supported:
 *  - push(int element)   : Insert element onto stack (with Overflow check)
 *  - pop()               : Remove and return top element (with Underflow check)
 *  - peek()              : View the top element without removing it
 *  - display()           : Print all elements from top to bottom
 *  - isEmpty() / isFull(): Helper status checks
 */

public class Q1_Stack {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with a specified size
    public Q1_Stack(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.top = -1; // -1 indicates that the stack is initially empty
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Push operation: inserts an element at the top
    public void push(int element) {
        // Stack Overflow condition
        if (isFull()) {
            System.out.println("[Error] Stack Overflow! Cannot push " + element + ". Stack is completely full.");
            return;
        }

        top++;
        arr[top] = element;
        System.out.println("Pushed " + element + " to stack.");
    }

    // Pop operation: removes and returns the top element
    public int pop() {
        // Stack Underflow condition
        if (isEmpty()) {
            System.out.println("[Error] Stack Underflow! Stack is empty, nothing to pop.");
            return -1;
        }

        int poppedValue = arr[top];
        top--;
        System.out.println("Popped " + poppedValue + " from stack.");
        return poppedValue;
    }

    // Peek operation: returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("[Notice] Stack is empty. No top element.");
            return -1;
        }
        return arr[top];
    }

    // Display operation: prints all current elements from top to bottom
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is currently empty: [ ]");
            return;
        }

        System.out.print("Current Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            if (i == top) {
                System.out.print(arr[i] + " (TOP)");
            } else {
                System.out.print(" -> " + arr[i]);
            }
        }
        System.out.println();
    }

    // Getter for current number of elements
    public int size() {
        return top + 1;
    }

    // Main method to demonstrate and test all operations
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("   QUESTION 1: STACK IMPLEMENTATION (ARRAY)     ");
        System.out.println("================================================\n");

        // 1. Create a stack of capacity 4
        Q1_Stack stack = new Q1_Stack(4);

        // 2. Test Underflow on empty stack
        System.out.println("--- 1. Testing Underflow Condition ---");
        stack.pop();
        stack.peek();
        System.out.println();

        // 3. Test Push operations
        System.out.println("--- 2. Testing Push Operations ---");
        stack.push(15);
        stack.push(25);
        stack.push(35);
        stack.push(45);
        stack.display();
        System.out.println("Current Top Element (peek): " + stack.peek());
        System.out.println();

        // 4. Test Overflow condition
        System.out.println("--- 3. Testing Overflow Condition ---");
        stack.push(55); // Exceeds capacity 4
        System.out.println();

        // 5. Test Pop operations
        System.out.println("--- 4. Testing Pop Operations ---");
        stack.pop();
        stack.display();
        System.out.println("New Top Element (peek): " + stack.peek());
        System.out.println();

        // 6. Empty the stack completely
        System.out.println("--- 5. Emptying the Stack ---");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
        System.out.println();
    }
}
