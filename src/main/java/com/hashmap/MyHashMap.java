package com.hashmap;

public class MyHashMap<K, V> {
    private final LinkedList myLinkedList;

    public MyHashMap() {
        this.myLinkedList = new LinkedList();
    }

    public V get(K key) {
        MapNode<K, V> myMapNode = (MapNode<K, V>) this.myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        MapNode<K, V> mapNode = (MapNode<K, V>) this.myLinkedList.search(key);
        if (mapNode == null) {
            mapNode = new MapNode<>(key, value);
            this.myLinkedList.append(mapNode);
        } else {
            mapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "hashMapNodes{" + myLinkedList + "}";
    }
}
