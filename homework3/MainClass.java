package ru.geekbrains.antonelenberger.homework3;



public class MainClass {

    public static void main(String[] args) {
        String source = "I hope that i will became great Software Engineer";
        turnAround(source);
    }

    /**
     * Метод для чтения строк справа на лево
     * @param str String которую читаем справа на лево
     */
    public static void turnAround(String str) {
        char[] temp = str.toCharArray();
        for(int i = temp.length - 1;i >=0; i--) {
            System.out.print(temp[i]);
        }
    }
}
