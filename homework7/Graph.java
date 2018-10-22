package ru.geekbrains.antonelenberger.homework7;


import java.util.Arrays;

public class Graph {

    private class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return "V: " + label;
        }
    }

    private final int MAX_VERTICES;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;

    public Graph(int maxVertices) {
        this.MAX_VERTICES = maxVertices;
        vertices = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size = 0;
    }

    public void addVertex(char label) {
        vertices[size++] = new Vertex(label);
    }

    public void addEdgeWithDirect(int start, int end) {

        adjMatrix[start][end] = 1;
        //adjMatrix[end][start] = 1;
    }

    public void addEdgeWithDirect(char start, char end) {
        int from = getLabeledVertex(start);
        int to = getLabeledVertex(end);
        addEdgeWithDirect(from, to);
    }

    public void printVertex(int vertex) {
        System.out.print(vertices[vertex] + " ");
    }

    private int getUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertices[i].wasVisited)
                return i;
        }
        return -1;
    }

    private int getLabeledVertex(char label) {
        for(int i = 0; i < vertices.length; i++) {
            if(vertices[i].label == label) return i;
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public void depthTravers() {
        Stack stack = new Stack(MAX_VERTICES);
        vertices[0].wasVisited = true;
        printVertex(0);
        stack.insert(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.remove();
            } else {
                vertices[v].wasVisited = true;
                printVertex(v);
                stack.insert(v);
            }
        }
        resetFlags();
    }

    public void widthTravers() {
        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        printVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()) {
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1) {
                vertices[vNext].wasVisited = true;
                printVertex(vNext);
                queue.insert(vNext);
            }
        }
        resetFlags();
    }

    public void shortestPath(char from, char to) {
        int start = getLabeledVertex(from);
        int end = getLabeledVertex(to);
        int[] endEdge = new int[MAX_VERTICES];
        Arrays.fill(endEdge, -1);
        endEdge[start] = start;
        Queue queue = new Queue(start);
        queue.insert(start);
        while(!queue.isEmpty()) {
            int current = queue.remove();
            int next;
            while((next = getUnvisitedVertex(current)) != -1) {
                endEdge[next] = current;
                if(next == end) {
                    printVertex(next);
                    resetFlags();
                    return;
                }
                vertices[next].wasVisited = true;
                queue.insert(next);
            }
            resetFlags();
        }
    }
}
