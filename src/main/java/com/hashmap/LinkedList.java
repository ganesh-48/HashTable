package com.hashmap;

public class LinkedList<K> {
    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public INode pop() {
        INode tempNode = this.head;
        this.head = this.head.getNext();
        return tempNode;
    }

    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals((tail))) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    public INode search(K key) {
        INode tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public boolean serchAndInsertElement(K key, INode insertNode) {
        INode tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                insert(tempNode, insertNode);
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }

    public Integer size() {
        Integer size = 0;
        INode tempNode = this.head;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.getNext();
        }
        return size;
    }

    public void searchAndDelete(K key) {
        INode findNode = search(key);
        if (findNode != null) {
            System.out.println("Linked List size before deleting element : " + size());
            INode nextNode = findNode.getNext();
            INode tempNode = nextNode.getNext();
            if (nextNode != tail) {
                findNode.setNext(tempNode);
                System.out.println("Linked List size after deleting element : " + size());

            }
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" + head + "}";
    }
}
