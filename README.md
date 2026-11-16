# Assignment: Stack and Queue (DS-3, Sections A & B)

**Subject:** Data Structures (DS-3)  
**Submission Date:** Monday, 16 November 2026  
**Implementation Language:** Java  

---

## Table of Contents
1. [Overview](#overview)
2. [Part 1: Stack](#part-1-stack)
   - [Question 1: Stack Implementation Using Array](#question-1-stack-implementation-using-array)
   - [Question 2: Stack Operations Trace & Final Contents](#question-2-stack-operations-trace--final-contents)
3. [Part 2: Queue](#part-2-queue)
   - [Question 3: Queue Implementation Using Array](#question-3-queue-implementation-using-array)
   - [Question 4: Queue Operations Trace & Final Contents](#question-4-queue-operations-trace--final-contents)
4. [File Structure](#file-structure)
5. [How to Compile and Run](#how-to-compile-and-run)
6. [Submission & Online Form](#submission--online-form)

---

## Overview

This assignment covers array-based implementations of fundamental linear data structures:
- **Stack:** LIFO (Last-In, First-Out) principle.
- **Queue:** FIFO (First-In, First-Out) principle.

Both implementations handle boundary conditions properly:
- **Overflow:** Occurs when an insertion operation is attempted on a full structure.
- **Underflow:** Occurs when a deletion operation is attempted on an empty structure.

---

## Part 1: Stack

### Question 1: Stack Implementation Using Array

#### Description:
A Stack is implemented using a fixed-size integer array with an index pointer `top`:
- Initial state: `top = -1` (stack is empty).
- `push(element)`: Checks if `top == capacity - 1`. If full, reports **Stack Overflow**. Otherwise, increments `top` and stores the element at `arr[top]`.
- `pop()`: Checks if `top == -1`. If empty, reports **Stack Underflow**. Otherwise, returns `arr[top]` and decrements `top`.
- `peek()`: Returns `arr[top]` without modifying `top`.
- `display()`: Iterates from `top` down to `0` to display the stack from top to bottom.

#### Complexity:
- `push()`: $O(1)$
- `pop()`: $O(1)$
- `peek()`: $O(1)$
- `display()`: $O(n)$

Source file: [`Q1_Stack.java`](./Q1_Stack.java)

---

### Question 2: Stack Operations Trace & Final Contents

#### Problem Statement:
Consider an initially empty Stack. Perform the following operations and show the Stack after each operation:
1. `Push(10)`
2. `Push(20)`
3. `Push(30)`
4. `Pop()`
5. `Push(40)`
6. `Pop()`

**What will be the final contents of the Stack, and what will be its top element?**

---

#### Step-by-Step Trace:

| Step | Operation | Action & Explanation | Stack Contents (Bottom to Top) | Top Element |
|:---:|:---|:---|:---:|:---:|
| 0 | *Initial* | Stack is initialized empty (`top = -1`) | `[ ]` | *None* |
| 1 | `Push(10)` | Insert `10` at index 0 (`top = 0`) | `[ 10 ]` | **10** |
| 2 | `Push(20)` | Insert `20` at index 1 (`top = 1`) | `[ 10, 20 ]` | **20** |
| 3 | `Push(30)` | Insert `30` at index 2 (`top = 2`) | `[ 10, 20, 30 ]` | **30** |
| 4 | `Pop()` | Remove top element `30` (`top = 1`) | `[ 10, 20 ]` | **20** |
| 5 | `Push(40)` | Insert `40` at index 2 (`top = 2`) | `[ 10, 20, 40 ]` | **40** |
| 6 | `Pop()` | Remove top element `40` (`top = 1`) | `[ 10, 20 ]` | **20** |

---

#### Visual Diagram:

```
Step 1: Push(10)      Step 2: Push(20)      Step 3: Push(30)
|    |                |    |                | 30 | <- top
|    |                | 20 | <- top         | 20 |
| 10 | <- top         | 10 |                | 10 |
+----+                +----+                +----+

Step 4: Pop() [30]    Step 5: Push(40)      Step 6: Pop() [40]
|    |                | 40 | <- top         |    |
| 20 | <- top         | 20 |                | 20 | <- top
| 10 |                | 10 |                | 10 |
+----+                +----+                +----+
```

---

#### Final Answer for Q2:
- **Final contents of the Stack (from bottom to top):** `[10, 20]`
- **Top element:** `20`

Source file: [`Q2_StackTrace.java`](./Q2_StackTrace.java)

---

## Part 2: Queue

### Question 3: Queue Implementation Using Array

#### Description:
A linear Queue is implemented using a fixed-size integer array with two pointers: `front` and `rear`:
- Initial state: `front = -1`, `rear = -1` (queue is empty).
- `enqueue(element)`: Checks if `rear == capacity - 1`. If true, reports **Queue Overflow**. When inserting the first element, `front` is set to `0`. `rear` is incremented and the element is stored at `arr[rear]`.
- `dequeue()`: Checks if `front == -1 || front > rear`. If true, reports **Queue Underflow**. Otherwise, retrieves `arr[front]` and increments `front`. If all elements have been dequeued (`front > rear`), resets `front = -1` and `rear = -1`.
- `front()`: Returns `arr[front]` without removal.
- `display()`: Iterates from `front` to `rear` to show elements in order of arrival.

#### Complexity:
- `enqueue()`: $O(1)$
- `dequeue()`: $O(1)$
- `front()`: $O(1)$
- `display()`: $O(n)$

Source file: [`Q3_Queue.java`](./Q3_Queue.java)

---

### Question 4: Queue Operations Trace & Final Contents

#### Problem Statement:
Consider an initially empty Queue. Perform the following operations and show the Queue after each operation:
1. `Enqueue(10)`
2. `Enqueue(20)`
3. `Enqueue(30)`
4. `Dequeue()`
5. `Enqueue(40)`
6. `Dequeue()`

**What will be the final contents of the Queue, and what will be its front element?**

---

#### Step-by-Step Trace:

| Step | Operation | Action & Explanation | Queue Contents (Front to Rear) | Front Pointer | Rear Pointer | Front Element |
|:---:|:---|:---|:---:|:---:|:---:|:---:|
| 0 | *Initial* | Queue is empty | `[ ]` | `-1` | `-1` | *None* |
| 1 | `Enqueue(10)` | Insert `10` at rear | `[ 10 ]` | `0` | `0` | **10** |
| 2 | `Enqueue(20)` | Insert `20` at rear | `[ 10, 20 ]` | `0` | `1` | **10** |
| 3 | `Enqueue(30)` | Insert `30` at rear | `[ 10, 20, 30 ]` | `0` | `2` | **10** |
| 4 | `Dequeue()` | Remove front element `10` | `[ 20, 30 ]` | `1` | `2` | **20** |
| 5 | `Enqueue(40)` | Insert `40` at rear | `[ 20, 30, 40 ]` | `1` | `3` | **20** |
| 6 | `Dequeue()` | Remove front element `20` | `[ 30, 40 ]` | `2` | `3` | **30** |

---

#### Visual Diagram:

```
Step 1: Enqueue(10)
Index:    0
Queue:  [ 10 ]
         ^ front, rear

Step 2: Enqueue(20)
Index:    0    1
Queue:  [ 10,  20 ]
         ^ front   ^ rear

Step 3: Enqueue(30)
Index:    0    1    2
Queue:  [ 10,  20,  30 ]
         ^ front     ^ rear

Step 4: Dequeue() -> Removed 10
Index:         1    2
Queue:       [ 20,  30 ]
               ^ front ^ rear

Step 5: Enqueue(40)
Index:         1    2    3
Queue:       [ 20,  30,  40 ]
               ^ front    ^ rear

Step 6: Dequeue() -> Removed 20
Index:              2    3
Queue:            [ 30,  40 ]
                    ^ front ^ rear
```

---

#### Final Answer for Q4:
- **Final contents of the Queue (from front to rear):** `[30, 40]`
- **Front element:** `30`

Source file: [`Q4_QueueTrace.java`](./Q4_QueueTrace.java)

---

## File Structure

```text
assiment/
├── Q1_Stack.java       # Question 1: Stack implementation with push, pop, peek, display & error handling
├── Q2_StackTrace.java  # Question 2: Simulation of step-by-step stack operations
├── Q3_Queue.java       # Question 3: Queue implementation with enqueue, dequeue, front, display & error handling
├── Q4_QueueTrace.java  # Question 4: Simulation of step-by-step queue operations
├── Main.java           # Master runner to execute all four questions in one click
└── README.md           # Complete assignment report with full theoretical and practical answers
```

---

## How to Compile and Run

### Prerequisites:
Make sure you have JDK (Java Development Kit) installed on your system.

### Option 1: Run All Questions Together (Master Runner)
```bash
javac Main.java Q1_Stack.java Q2_StackTrace.java Q3_Queue.java Q4_QueueTrace.java
java Main
```

### Option 2: Run Individual Questions

- **Question 1 (Stack Program):**
  ```bash
  javac Q1_Stack.java
  java Q1_Stack
  ```

- **Question 2 (Stack Simulation Trace):**
  ```bash
  javac Q2_StackTrace.java
  java Q2_StackTrace
  ```

- **Question 3 (Queue Program):**
  ```bash
  javac Q3_Queue.java
  java Q3_Queue
  ```

- **Question 4 (Queue Simulation Trace):**
  ```bash
  javac Q4_QueueTrace.java
  java Q4_QueueTrace
  ```

---

## Submission & Online Form

1. **GitHub Upload:**
   - Initialize git: `git init`
   - Stage all files: `git add .`
   - Commit: `git commit -m "Submit Stack and Queue Assignment (DS-3)"`
   - Push to your personal GitHub repository:
     ```bash
     git remote add origin <YOUR_GITHUB_REPO_URL>
     git branch -M main
     git push -u origin main
     ```

2. **Online Form:**
   - Link: [Assignment Submission Google Form](https://docs.google.com/forms/d/e/1FAIpQLSfB9k14wkMhyqAvTrFFNTuOgRORa8-1sHvIRdV-ihnkRlAzDQ/viewform?usp=publish-editor)
   - Paste your GitHub repository link and submit before the deadline.
