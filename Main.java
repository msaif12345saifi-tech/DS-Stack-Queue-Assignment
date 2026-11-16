/**
 * Assignment: Stack and Queue (DS-3, Sections A & B)
 * Master Runner to execute all four questions in one go.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("*************************************************************");
        System.out.println("   DATA STRUCTURES (DS-3, Sections A & B) - ASSIGNMENT       ");
        System.out.println("                 STACK AND QUEUE IMPLEMENTATION              ");
        System.out.println("*************************************************************\n");

        // Execute Question 1
        System.out.println(">>> RUNNING PART 1 - QUESTION 1 <<<");
        Q1_Stack.main(args);
        System.out.println("\n");

        // Execute Question 2
        System.out.println(">>> RUNNING PART 1 - QUESTION 2 <<<");
        Q2_StackTrace.main(args);
        System.out.println("\n");

        // Execute Question 3
        System.out.println(">>> RUNNING PART 2 - QUESTION 3 <<<");
        Q3_Queue.main(args);
        System.out.println("\n");

        // Execute Question 4
        System.out.println(">>> RUNNING PART 2 - QUESTION 4 <<<");
        Q4_QueueTrace.main(args);
        System.out.println("\n");

        System.out.println("*************************************************************");
        System.out.println("             ALL ASSIGNMENT TASKS COMPLETED!                 ");
        System.out.println("*************************************************************");
    }
}
