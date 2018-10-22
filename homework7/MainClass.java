package ru.geekbrains.antonelenberger.homework7;

public class MainClass {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('h');
        graph.addVertex('i');
        graph.addVertex('j');
        graph.addEdgeWithDirect('a', 'c');
        graph.addEdgeWithDirect('d', 'e');
        graph.addEdgeWithDirect('b', 'j');
        graph.addEdgeWithDirect('a', 'd');
        graph.addEdgeWithDirect('a', 'j');
        graph.addEdgeWithDirect('b', 'e');
        graph.addEdgeWithDirect('j', 'd');
        graph.addEdgeWithDirect('b', 'c');
        graph.addEdgeWithDirect('a', 'b');
        graph.addEdgeWithDirect('f', 'e');

        graph.shortestPath('a', 'c');
    }

}

