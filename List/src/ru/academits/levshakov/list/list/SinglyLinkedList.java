package ru.academits.levshakov.list.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count; //длина списка

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;

        count = 1;

        for (ListItem<T> p = head.getNext(); p != null; p = p.getNext()) {
            count += 1;
        }
    }

    public ListItem<T> getHead() {
        return head;
    }

    public int getListSize() {
        return count;
    }

    public T getFirstElementData() {
        return head.getData();
    }

    public T getDataAtIndex(int index) {
        if (index <= 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }

        ListItem<T> link = head.getNext();

        for (int i = 1; i < index; i++) {
            link = link.getNext();
        }

        return link.getData();
    }

    public void setDataAtIndex(T data, int index) {
        if (index <= 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }

        ListItem<T> link = head.getNext();

        for (int i = 1; i < index; i++) {
            link = link.getNext();
        }

        link.setData(data);
    }

    public void deleteElementAtIndex(int index) {
        if (index <= 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }

        ListItem<T> previousElement = head;

        for (int i = 0; i < index - 1; i++) {
            previousElement = previousElement.getNext();
        }

        previousElement.setNext(previousElement.getNext().getNext());

        count -= 1;
    }

    public void insertElementAtHead(T data) {
        head = new ListItem<T>(data, head);

        count += 1;
    }

    public void insertElementAtIndex(T data, int index) {
        if (index <= 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }

        ListItem<T> newListItem = new ListItem<>(data);

        ListItem<T> previousElement = head;

        for (int i = 0; i < index - 1; i++) {
            previousElement = previousElement.getNext();
        }

        newListItem.setNext(previousElement.getNext());

        previousElement.setNext(newListItem);
    }

    public boolean removeElementWithData(T data) {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if(data.equals(p.getData())) {
                break;
            }
        }
    }

    public T deleteFirstElement() {
        T result = head.getData();
        head = head.getNext();

        count -= 1;

        return result;
    }

 /*   public void rotateList() {
        //TODO
    }

    public SinglyLinkedList<T> copyList() {
        //TODO
    } */
}
