package ru.geekbrains.antonelenberger.homework4;



public class LinkIteratorApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkedList.LinkedListIterator itr = new LinkedList.LinkedListIterator(list);

        list.insertLast(new Cat(4,"Barsik"));
        list.insertLast(new Cat(4,"Vaska"));
        list.insertLast(new Cat(4,"Jack"));
        list.insertLast(new Cat(4,"MKoon"));
        list.insertLast(new Cat(4,"LuckyB"));
        list.insertLast(new Cat(4,"Not on the floor"));
        list.insertFirst(new Cat(3, "Smelly Cat"));
        list.removeFirst();
        list.removeLast();
        itr.atTail();
        itr.insertAfter(new Cat(7, "Cap"));
        itr.insertBefore(new Cat(9, "Grumpy"));
        itr.getCurrent();
        itr.nextNode();
        itr.reset();
    }
}
