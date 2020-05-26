class MyCircularDeque {

    int[] myqueue;
    private int head; // 标记队首位置
    private int tail; // 标记队尾位置
    private int size; // 队列当前元素
    private int capacity; // 队列容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.myqueue = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        // 如果队列满, 直接返回
        if (head == tail && size == capacity) {
            return false;
        }
        head = (head - 1 + capacity) % capacity; // 放置下标越界
        myqueue[head] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (head == tail && size == capacity) {
            return false;
        }
        myqueue[tail] = value;
        tail = (tail + 1 + capacity) % capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (head == tail && size == 0) {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (head == tail && size == 0) {
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (head == tail && size == 0) {
            return -1;
        }
        int front = myqueue[head];
        return front;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (head == tail && size == 0) {
            return -1;
        }
        int rear = myqueue[(tail - 1 + capacity) % capacity];
        return rear;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail && size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return head == tail && size == capacity;
    }
}
