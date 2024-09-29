class MyCircularDeque {
    private LinkedList<Integer> deq;  // Using LinkedList to store deque elements
    private int cnt;                  // Current number of elements in the deque
    private int k;                    // Maximum capacity of the deque

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.k = k;                   // Assign capacity
        this.deq = new LinkedList<>(); // Initialize the deque as an empty LinkedList
        this.cnt = 0;                  // Initialize count to 0
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (cnt == k) {
            return false;              // If the deque is full, insertion fails
        }
        deq.addFirst(value);           // Insert at the front of the deque
        cnt++;                         // Increment count
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (cnt == k) {
            return false;              // If the deque is full, insertion fails
        }
        deq.addLast(value);            // Insert at the rear of the deque
        cnt++;                         // Increment count
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (cnt == 0) {
            return false;              // If the deque is empty, deletion fails
        }
        deq.removeFirst();             // Remove the front element
        cnt--;                         // Decrement count
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (cnt == 0) {
            return false;              // If the deque is empty, deletion fails
        }
        deq.removeLast();              // Remove the last element
        cnt--;                         // Decrement count
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (cnt == 0) {
            return -1;                 // If the deque is empty, return -1
        }
        return deq.getFirst();          // Return the front element
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (cnt == 0) {
            return -1;                 // If the deque is empty, return -1
        }
        return deq.getLast();           // Return the last element
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;               // Return true if the deque is empty
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cnt == k;               // Return true if the deque is full
    }
}