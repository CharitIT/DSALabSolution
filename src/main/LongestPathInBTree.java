package main;

import java.util.ArrayList;

public class LongestPathInBTree {
    //Static Node
    static class Node {
        Node leftNode;
        Node rightNode;
        int data;
    };
    //Method to create a new Binary Node
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.leftNode = null;
        temp.rightNode = null;
        return temp;
    }

    // Method to find the longest path
    public static ArrayList<Integer> longestPath(Node root) {
        // If root is null then return empty list
        if (root == null) {
            ArrayList<Integer> list = new ArrayList<>();
            return list;
        }
        // Collecting the right subtree data
        ArrayList<Integer> rightList = longestPath(root.rightNode);
        // Collecting the left subtree data
        ArrayList<Integer> leftList = longestPath(root.leftNode);
        // Comparing the size for left and right traversals, and based on comparison, adding root data to larger subtree list
        if (rightList.size() < leftList.size()) {
            leftList.add(root.data);
        } else {
            rightList.add(root.data);
        }
        // Return list with bigger size
        return (leftList.size() > rightList.size() ? leftList : rightList);
    }

    // Main Driver Program
    public static void main(String[] args) {
        //Tree with the data
        Node root = newNode(100);
        root.leftNode = newNode(20);
        root.rightNode = newNode(130);
        root.leftNode.leftNode = newNode(10);
        root.leftNode.rightNode = newNode(50);
        root.rightNode.leftNode = newNode(110);
        root.rightNode.rightNode = newNode(140);
        root.leftNode.leftNode.leftNode = newNode(5);
        //Result Array List That Will Process With Recursion
        ArrayList<Integer> resultList = longestPath(root);
        int size = resultList.size();
        System.out.print("Longest path ");
        System.out.print(resultList.get(size - 1));
        //Elements From Root Towards Leaf Node
        for (int i = size - 2; i >= 0; i--) {
            System.out.print(" -> " + resultList.get(i));
        }
    }
}