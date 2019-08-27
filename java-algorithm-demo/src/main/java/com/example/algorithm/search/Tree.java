package com.example.algorithm.search;

public class Tree {

    private Node node;
    public static void main(String[] args) {
        Node node = new Node();
    }



   private static class Node{
        private Object data;  //节点数据
        private Tree leftChild; //左子节点的引用
        private Tree rightChild; //右子节点的引用
    }
}
