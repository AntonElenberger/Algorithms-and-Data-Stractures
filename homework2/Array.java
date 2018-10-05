package ru.geekbrains.antonelenberger.homework2;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    /**
     * Метод удаляет заданый индекс
     * @param index индекс массива подлежайщий удалению
     * @return возвращает true если элемент успешно удален
     */
    boolean delete(int index) { // by index
        if (size == 0) return false;
        if (index > size) throw new IndexOutOfBoundsException("index is bigger than size of array");
        for (int i = index; i < size - 1 ; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    /**
     * Метод удаляет все значения равные value в массиве
     * @param value значение которое нужно удалить
     * @return возвращает true если значение удалено
     */
    boolean deleteAll(int value) { // by value
        if (size == 0) return false;
        int i;
        boolean del = false;
        for (i = 0; i < size; i++) {
            if (arr[i] == value) {
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
                del = true;
            }
        }
        if(!del) {
            System.out.println("no such value");
            return false;
        }
        return true;
    }

    /**
     * Метод удаляет все элементы из массива
     */
    void deleteAll() { // clear array
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }

    /**
     * Метод использует сортировку пузырьком с флагом, который возвращает false если не был
     * вызван метод swap, то есть если массив уже отсартирован.
     */
    public void sortBubbleWithFlag() {
        boolean swapped;
        for (int i = 0; i < size; i++) {
            int min = i;
            swapped = false;
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
                swapped = true;
            }
        }
    }

    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
    }

    public void sortInsert() {
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }
}
