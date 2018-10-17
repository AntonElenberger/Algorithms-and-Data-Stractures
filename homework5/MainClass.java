package ru.geekbrains.antonelenberger.homework5;

public class MainClass {

    public static void main(String[] args) {
        System.out.println(calcInc(2, 10));
        String left = "left";
        String right = "right";
        String aux = "auxiliary";
        hanoiTowers(3, left, right, aux);
    }

    private static int calcInc(int base, int inc) {
        if(inc == 0) {
            return 1;
        }
        if(inc % 2 == 1) {
            return calcInc(base, inc - 1) * base;
        } else {
            int i = calcInc(base, inc / 2);
            return i * i;
        }
    }

    private static void printMove(String from, String to) {
        System.out.println("Move disc from " + from + " to " + to + ".");
    }

    private static void hanoiTowers(int n, String from, String to, String auxiliary) {
        if(n == 1) {
            printMove(from,to);
        } else {
            hanoiTowers(n - 1, from, auxiliary, to);
            hanoiTowers(1, from, to, auxiliary);
            hanoiTowers(n - 1, auxiliary, to, from);
        }
    }
}
