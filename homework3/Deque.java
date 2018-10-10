package ru.geekbrains.antonelenberger.homework3;

/**
 * Класс Дек
 */
public class Deque {
    private int[] deque;
    private int size;
    private int tail;

    public Deque(int size) {
        this.size = size;
        this.deque = new int[size];
        tail = 0;
    }

    public boolean isEmpty() {
        return tail == 0;
    }

    public int length() {
        return tail;
    }

    public void insertHead(int value) {
        if(tail == size) throw new RuntimeException("Deque is full");
         for(int i = tail; i > 0; i--) {
             deque[i] = deque[i - 1];
         }
         deque[0] = value;
         tail++;
    }

    public void insertTail(int value) {
        if(tail == size) throw new RuntimeException("Deque is full");
        deque[++tail] = value;
    }

    public int removeHead() {
        if(isEmpty()) throw new RuntimeException("Deque is empty");
        int head = deque[0];
        for(int i = 0; i < tail; i++) {
            deque[i] = deque[i+ 1];
        }
        tail--;
        return head;
    }

    public int removeTail() {
        if(isEmpty()) throw new RuntimeException("Deque is empty");
        return deque[tail--];
    }
}
