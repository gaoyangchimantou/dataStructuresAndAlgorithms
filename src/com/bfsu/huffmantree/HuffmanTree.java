package com.bfsu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args) {

        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node huffmanTree = createHuffmanTree(arr);
        preOrder(huffmanTree);
    }

    public static void preOrder(Node node){
        node.preOrder();
    }

    /**
     * 将一个数组 构建成huffman树
     * @param arr
     * @return
     */
    public static Node createHuffmanTree(int[] arr){
        List<Node> list=new ArrayList<Node>();
        //现将数组 转化为节点的集合
        if(arr!=null&&arr.length>0){
            for (int value:arr) {
                list.add(new Node(value));
            }
        }
        while (list.size()>1){
            Collections.sort(list);
            Node nodeLeft = list.get(0);
            Node nodeRight = list.get(1);
            Node temp=new Node(nodeLeft.value+nodeRight.value);
            temp.left=nodeLeft;
            temp.right=nodeRight;
            list.remove(nodeLeft);
            list.remove(nodeRight);
            list.add(temp);
        }
        return  list.get(0);
    }



}
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }

    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}