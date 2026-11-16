/**
 * Assignment: Stack and Queue (DS-3, Sections A & B)
 * Question 2: Step-by-Step Stack Operation Simulation
 *
 * Sequence of operations:
 *   1. Push(10)
 *   2. Push(20)
 *   3. Push(30)
 *   4. Pop()
 *   5. Push(40)
 *   6. Pop()
 *
 * This program runs the exact sequence and displays the state of the stack
 * and the top pointer after every single operation.
 */

public class Q2_StackTrace {
    private int[] stack;
    private int top;
    private int capacity;

    public Q2_StackTrace(int size) {
        this.capacity = size;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        top++;
        stack[top] = element;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int removed = stack[top];
        top--;
        return removed;
    }

    public int peek() {
        if (top == -1) return -1;
        return stack[top];
    }

    // Print stack contents clearly from bottom to top
    public void printStackState() {
        if (top == -1) {
            System.out.println("    Stack State: [ EMPTY ]");
            System.out.println("    Top Element: None\n");
            return;
        }

        System.out.print("    Stack State (Bottom to Top): [ ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);
            if (i < top) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
        System.out.println("    Top Element: " + stack[top]);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("    QUESTION 2: TRACE OF STACK OPERATIONS (STEP-BY-STEP)");
        System.out.println("========================================================\n");

        Q2_StackTrace s = new Q2_StackTrace(10);

        System.out.println("Initial State: Initially Empty Stack");
        s.printStackState();

        // Step 1: Push(10)
        System.out.println("Step 1: Execute Push(10)");
        s.push(10);
        s.printStackState();

        // Step 2: Push(20)
        System.out.println("Step 2: Execute Push(20)");
        s.push(20);
        s.printStackState();

        // Step 3: Push(30)
        System.out.println("Step 3: Execute Push(30)");
        s.push(30);
        s.printStackState();

        // Step 4: Pop()
        System.out.println("Step 4: Execute Pop()");
        int popped1 = s.pop();
        System.out.println("    Popped Value: " + popped1);
        s.printStackState();

        // Step 5: Push(40)
        System.out.println("Step 5: Execute Push(40)");
        s.push(40);
        s.printStackState();

        // Step 6: Pop()
        System.out.println("Step 6: Execute Pop()");
        int popped2 = s.pop();
        System.out.println("    Popped Value: " + popped2);
        s.printStackState();

        // Final Summary
        System.out.println("========================================================");
        System.out.println("                    FINAL RESULT                        ");
        System.out.println("========================================================");
        System.out.println("Final Contents of the Stack (Bottom to Top) : [ 10, 20 ]");
        System.out.println("Top Element of the Stack                    : " + s.peek());
        System.out.println("========================================================");
    }
}
