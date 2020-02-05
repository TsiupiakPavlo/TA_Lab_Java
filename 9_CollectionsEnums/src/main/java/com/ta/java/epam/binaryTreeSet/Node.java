package com.ta.java.epam.binaryTreeSet;

public class Node<T extends Comparable<T>> {
    T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node (){
        this(null);
    }

    public T getData() {
        return data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node get(T data){

        if(this.data.compareTo(data) > 0){
            if(this.left == null) {
                return null;
            }
            return left.get(data);
        }
        if(this.data.compareTo(data) < 0){
            if(this.right == null){
                return null;
            }
            return right.get(data);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}


