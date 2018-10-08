package ru.geekbrains.antonelenberger.homework3;

/**
 * Приорететная очередь(попытка) в метод insert добавлен параметр веса значения,
 * вставка происходит по номеру элемента масива со сдвигом всех элементов вправо.
 */
public class PriorityQueue {
    private int[] priorityQueue;
    private int head;
    private int tail;
    private int size;
    private int items;

    public PriorityQueue(int size) {
        this.size = size;
        this.priorityQueue = new int[size];
        head = 0;
        tail = -1;
        items = 0;
    }
    public boolean isEmpty() {
        return items == 0;
    }
    public boolean isFull() {
        return items == size;
    }
    public int length() {
        return items;
    }
    public void insert(int i, int weight) {
        if (isFull()) {
            size *= 2;
            int[] temp = new int[size];
            if (tail >= head) {
                System.arraycopy(priorityQueue, 0, temp, 0, priorityQueue.length);
            } else {
                System.arraycopy(priorityQueue, 0, temp, 0, tail - 1);
                System.arraycopy(priorityQueue, head, temp,
                        size - (priorityQueue.length - head),
                        priorityQueue.length - head - 1);
                head = size - head - 1;
            }
            priorityQueue = temp;
        }
        if (tail == size - 1)
            tail = -1;
        int j;
        for(j = weight; j < items; j++) {
            priorityQueue[j] = priorityQueue[j + 1];
        }
        priorityQueue[j] = i;
        items++;
    }
    public int remove() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = priorityQueue[head++];
        head %= size;
        items--;
        return temp;
    }
    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return priorityQueue[head];
    }
}
