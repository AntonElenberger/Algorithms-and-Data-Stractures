package ru.geekbrains.antonelenberger.homework6;

import java.util.Random;

public class MainClass {
    private static final int TREENODES = 20;
    private static final int TREEQTY = 20;

    public static void main(String[] args) {
        int qtyOfBalancedTrees = 0;
        int percentOfBalancedTrees = 100 * (qtyOfBalancedTrees / TREEQTY);
        for(int i = 0; i < TREEQTY; i++) {
            if(newTree().isBalanced()) qtyOfBalancedTrees++;
        }
        System.out.println("Процент сбалансированных деревьев " + percentOfBalancedTrees + "%.");
    }

    /**
     * Метод рандомно создает новое дерево.
     * @return возвращает созданое дерево.
     */
    private static Tree newTree() {
        Tree tree = new Tree();
        Random random = new Random();
        for(int i = 0; i < TREENODES; i++) {
            tree.insert(random.nextInt(100));
        }
        return tree;
    }
}
