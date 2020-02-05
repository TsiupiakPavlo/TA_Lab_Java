package com.ta.java.epam.binaryTreeSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int size;

    public Node getRoot() {
        return this.root;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> tempNode = root;
            Node<T> prev = null;
            while (tempNode != null) {
                prev = tempNode;
                if (data.compareTo(tempNode.data) > 0) {
                    tempNode = tempNode.right;
                } else {
                    tempNode = tempNode.left;
                }
            }
            if (data.compareTo(prev.data) < 0) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }
        }
        ++size;
    }

    public boolean remove(T value) {
        return removeRecursive(root, null, value);
    }

    private boolean removeRecursive(Node<T> current, Node<T> parent, T value) {
        if (current == null) {
            return false;
        }

        int comparisonResult = value.compareTo(current.getData());

        if (comparisonResult < 0) {
            return removeRecursive(current.getLeft(), current, value);

        } else if (comparisonResult > 0) {
            return removeRecursive(current.getRight(), current, value);

        }

        int childCount = 0;
        childCount += (current.getLeft() == null) ? 0 : 1;
        childCount += (current.getRight() == null) ? 0 : 1;

        if (childCount == 0) {
            if (current == root) {
                root = null;
                --size;
                return true;
            }
            if (parent.getLeft() == current) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            --size;
            return true;
        } else if (childCount == 1) {
            if (current == root) {
                if (root.getLeft() != null) {
                    root = root.getLeft();
                } else {
                    root = root.getRight();
                }
                --size;
                return true;
            }

            Node<T> child = (current.getLeft() != null) ?
                    current.getLeft() :
                    current.getRight();

            if (parent.getLeft() == current) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
            --size;
            return true;
        }
        return false;
    }

    public void traverseInOrder(Node<T> root, List<T> storageList) {
        if (root != null) {
            traverseInOrder(root.left, storageList);
            storageList.add(root.data);
            traverseInOrder(root.right, storageList);
        }
    }

    public void printTree(Node<T> root) {
        if(root == null) return;

        System.out.println("" + root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }


    public static void main(String args[]) {
        BinarySearchTree<Integer> bTree = new BinarySearchTree<>();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        bTree.add(50);
        bTree.add(30);
        bTree.add(20);
        bTree.add(40);
        bTree.add(70);
        bTree.add(60);
        bTree.add(80);

        System.out.println("#### Print Tree ####");
        bTree.printTree(bTree.getRoot());
        System.out.println("#### Remove 90 ####");
        bTree.remove(80);
        bTree.printTree(bTree.getRoot());

        System.out.println("#### Inorder Traversal ####");
        List<Integer> inOrderList = new ArrayList<>();
        bTree.traverseInOrder(bTree.getRoot(), inOrderList);
        bTree.printList(inOrderList);
    }
}
