package com.hashmap;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
    private final int numberBuckets;
    ArrayList<MyLinkedList<K>> myBucketArray;

    public MyLinkedHashMap() {
        this.numberBuckets = 10;
        this.myBucketArray = new ArrayList<>(numberBuckets);
        //Create empty Linked List
        for (int i = 0; i < numberBuckets; i++)
            this.myBucketArray.add(null);
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs((key.hashCode()));
        int index = hashCode % numberBuckets;
        return index;
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) return null;
        MapNode<K, V> myMapNode = (MapNode<K, V>) LinkedList.search(key);
        return (myMapNode == null) ? null : MapNode.getValue();
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new LinkedList<>();
            this.myBucketArray.set(index, myLinkedList);
        }
        MapNode<K, V> myMapNode = (MapNode<K, V>) LinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MapNode<>(key, value);
            LinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "MyLinkedHashMap List {" + myBucketArray + "}";
    }
}
