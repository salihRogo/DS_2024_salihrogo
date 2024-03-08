package week2;

import java.util.NoSuchElementException;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;
    private int size = 0;

    public QueueBasedStack() {
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    public void push(Data data) {
        // your code here
        q2.enqueue(data);

        while(!q1.isEmpty()) {
            Data temp = q1.dequeue();
            q2.enqueue(temp);
        }

        while(!q2.isEmpty()) {
            Data temp = q2.dequeue();
            q1.enqueue(temp);
        }

        size++;
    }

    public Data pop() {
        // your code here (remove next line)
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        size--;
        return q1.dequeue();
    }

    public Data peek() {
        // your code here (remove next line)
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return q1.peek();
    }

    public int size() {
        // your code here (remove next line)
        return size;
    }

    public boolean isEmpty() {
        // your code here (remove next line)
        return size == 0;
    }
}
