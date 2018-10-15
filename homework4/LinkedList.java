package ru.geekbrains.antonelenberger.homework4;


public class LinkedList {

    protected class Node {
        Cat c;
        Node next;
        Node prev;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Node)) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }

        @Override
        public String toString() {
            return c.toString();
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(Cat c) {
        Node n = new Node(c);
        Node temp = head;
        head = n;
        head.next = temp;
        if(isEmpty()) {
            tail = head;
        } else {
            temp.prev = head;
        }
    }

    public void insertLast(Cat c) {
        Node n = new Node(c);
        if(isEmpty()) {
            head = n;
        } else {
            tail.next = n;
            n.prev = tail;
        }
        tail = n;
    }

    public Cat removeFirst() {
        if(isEmpty()) {
            return null;
        } else {
            Cat c = head.c;
            head = head.next;
            if(isEmpty()) {
                tail = null;
            } else {
                head.prev = null;
            }
            return c;
        }

    }

    public Cat removeLast() {
        if(isEmpty()) {
            return null;
        } else {
            Cat c = tail.c;
            tail.prev.next = null;
            tail = tail.prev;
            return c;
        }
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        if (isEmpty())
            return false;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    public boolean delete(Cat c) {
        Node n = new Node(c);
        Node current = head;
        Node previous = head;

        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else {
                previous = current;
                current = current.next;
            }
        }

        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }

        return true;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public LinkedListIterator getIterator() {
        return new LinkedListIterator(this);
    }
    static class LinkedListIterator {
        private Node current;
        private Node previous;
        private LinkedList list;

        public LinkedListIterator(LinkedList list) {
            this.list = list;
            this.reset();
        }

        public void reset() {
            current = list.getHead();
            previous = null;
        }

        public boolean atTail() {
            return current.next == null;
        }

        public void nextNode() {
            previous = current;
            current = current.next;
        }

        public Node getCurrent() {
            return current;
        }

        public void insertAfter(Cat c) {
            Node n = new Node(c);
            if(list.isEmpty()) {
                list.setHead(n);
                current = n;
            } else {
                n.next = current.next;
                current.next = n;
                nextNode();
            }
        }
        public void insertBefore (Cat c){
            Node n = new Node(c);
            if (previous == null){
                n.next = list.getHead();
                list.setHead(n);
                reset();
            }
            else{
                n.next = previous.next;
                previous.next = n;
                current = n;
            }
        }
    }
}
