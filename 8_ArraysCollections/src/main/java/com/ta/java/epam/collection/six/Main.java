package com.ta.java.epam.collection.six;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();
        testAddLast(deque);
        testRemoveLast(deque);
        testIsEmptySize(deque);
        testClear();

        deque = new ArrayDeque<String>();
        testAddFirst(deque);
        testRemoveFirst(deque);

        testIteratorIterable();
    }

    private static void testAddLast(Deque<String> deque) {
        System.out.println("addLast, toString:");
        deque.addLast("seven");
        System.out.println(deque);
        deque.addLast("years");
        System.out.println(deque);
        deque.addLast("ago");
        System.out.println(deque);
    }

    private static void testRemoveLast(Deque<String> deque) {
        System.out.println();
        System.out.println("removeLast:");
        System.out.println(deque.removeLast());
        System.out.println(deque);
        System.out.println(deque.removeLast());
        System.out.println(deque);
        System.out.println(deque.removeLast());
        System.out.println(deque);
    }

    private static void testIsEmptySize(Deque<String> deque) {
        System.out.println();
        System.out.println("isEmpty / size:");
        System.out.println(deque + ", size " + deque.size() + ", empty?  " + deque.isEmpty());
        deque.addLast("seven");
        System.out.println(deque + ", size " + deque.size() + ", empty?  " + deque.isEmpty());
        deque.addLast("years");
        System.out.println(deque + ", size " + deque.size() + ", empty?  " + deque.isEmpty());
        deque.addLast("ago");
        System.out.println(deque + ", size " + deque.size() + ", empty?  " + deque.isEmpty());
        while (!deque.isEmpty()) {
            System.out.println(deque.removeLast());
            System.out.println(deque + ", size " + deque.size() + ", empty? " + deque.isEmpty());
        }
    }

    private static void testClear() {
        System.out.println();
        System.out.println("clear:");
        Deque<String> deque = new ArrayDeque<String>();
        deque.addLast("com.ta.java.epam.four");
        deque.addLast("score");
        deque.addLast("and");
        deque.addLast("seven");
        deque.addLast("years");
        deque.addLast("ago");
        System.out.println(deque + ", size " + deque.size() + ", empty? " + deque.isEmpty());
        deque.clear();
        System.out.println(deque + ", size " + deque.size() + ", empty? " + deque.isEmpty());
    }

    private static void testAddFirst(Deque<String> deque) {
        System.out.println();
        System.out.println("addFirst:");
        deque.addFirst("and");
        System.out.println(deque);
        deque.addFirst("score");
        System.out.println(deque);
        deque.addFirst("com.ta.java.epam.four");
        System.out.println(deque);

        deque.addLast("seven");
        System.out.println(deque);
        deque.addLast("years");
        System.out.println(deque);
        deque.addLast("ago");
        System.out.println(deque);
    }

    private static void testRemoveFirst(Deque<String> deque) {
        System.out.println();
        System.out.println("removeFirst:");
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
            System.out.println(deque);
        }
    }

    private static void testIteratorIterable() {
        System.out.println();
        System.out.println("iterator:");
        Deque<String> deque = new ArrayDeque<String>();
        deque.addFirst("and");
        deque.addLast("seven");
        deque.addFirst("score");
        deque.addLast("years");
        deque.addFirst("com.ta.java.epam.four");
        deque.addLast("ago");
        Iterator<String> itr = deque.iterator();
        while (itr.hasNext()) {
            System.out.println("iterator next() = " + itr.next());
        }

        System.out.println();
        System.out.println("Iterable:");
        for (String s : deque) {
            System.out.println("foreach loop value = " + s);
        }

    }
}
