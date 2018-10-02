package ru.geekbrains.antonelenberger.homework1;

public class HomeWork {

    public static void main(String[] args) {
        increment(2, 13);
        minElementOfArray();
        average();
    }

    /**
     * Метод возводит в степень используя четность степени, что является сложностью O(Log n),
     * так как мы делим количество условных операций пополам.
     * @param base основаение
     * @param n степень
     */
    static void increment(int base, int n) {
        int counter = 1;
        while(n > 0) {
            if(n % 2 == 0) {
                n /= 2;
                base *= base;
            } else {
                counter *= base;
                n--;
            }
        }
        System.out.println(counter);
    }

    /**
     * Метод пробегоет по всему масиву в поисках минимального значения.
     * Сложность O(n), так как мы по порядку проходим по всем элементам массива.
     */
    static void minElementOfArray() {
        int[] array = new int[]{5,6,8,4,7,2,8,4,6,3};
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("Минимальное значение массива: " + min);
    }

    /**
     * Метод пробегает по массиву складывая с друг другом свои элементы в переменную sum,
     * затем находит среднее арифметическое делением sum на длинну масива.
     * Сложность O(n), так как время выполнения, как и в задаче с нахождением минимума, растет пропорционально
     * количеству элементов массива.
     */
    static void average() {
        int average;
        int sum = 0;
        int[] array = new int[]{5,8,6,1,3,4,8,4,6,64,115,8,9,6,3,21,13,15,54,46,4};
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        average = sum / array.length;
        System.out.println("Среднее арифметическое массива: " + average);
    }
}
