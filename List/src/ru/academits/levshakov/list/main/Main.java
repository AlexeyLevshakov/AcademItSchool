package ru.academits.levshakov.list.main;

import ru.academits.levshakov.list.list.ListItem;
import ru.academits.levshakov.list.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        ListItem<Integer> listItem3 = new ListItem<>(3, null);
        ListItem<Integer> listItem2 = new ListItem<>(2, listItem3);
        ListItem<Integer> listItem1 = new ListItem<>(1, listItem2);
        ListItem<Integer> listItem0 = new ListItem<>(0, listItem1);

        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>(listItem0);

        System.out.println(myList.getListSize());

        System.out.println(myList.getFirstElementData());

        System.out.println(myList.getDataAtIndex(2));

        myList.setDataAtIndex(10, 2);

        System.out.println(myList.getDataAtIndex(2));

        System.out.println();

        for (ListItem<Integer> p = myList.getHead(); p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }

        System.out.println();

        myList.deleteElementAtIndex(2);

        System.out.println();

        for (ListItem<Integer> p = myList.getHead(); p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }

        System.out.println();
        System.out.println(myList.getListSize());

        myList.insertElementAtHead(10);

        System.out.println();

        for (ListItem<Integer> p = myList.getHead(); p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }

        System.out.println();
        System.out.println(myList.getListSize());

        myList.deleteFirstElement();

        System.out.println();

        for (ListItem<Integer> p = myList.getHead(); p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }

        System.out.println();
        System.out.println(myList.getListSize());

        myList.insertElementAtIndex(10, 1);

        System.out.println();

        for (ListItem<Integer> p = myList.getHead(); p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }

        System.out.println();
        System.out.println(myList.getListSize());


    }
}
