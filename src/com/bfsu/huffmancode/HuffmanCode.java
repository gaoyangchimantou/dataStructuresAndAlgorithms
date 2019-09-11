package com.bfsu.huffmancode;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        //将 byte数组  转化为 node集合   先算出各个元素的个数
   /*    List<Node> contentList=new ArrayList<Node>();
        Map<Byte,Integer> contentMap=new HashMap<Byte,Integer>();
        for (Byte b:bytes) {
            if(contentMap.get(b)==null){
                contentMap.put(b,1);
            }else {
                contentMap.put(b,contentMap.get(b)+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:contentMap.entrySet()) {
            contentList.add(new Node(entry.getKey(),entry.getValue()));
        }
        Node huffmanTreeRoot = createHuffmanTree(contentList);
        preOrder(huffmanTreeRoot);
        getCodes(huffmanTreeRoot);*/
      /*  System.out.println(huffmanCodes);*/
     /*  byte[] zip = zip(bytes, huffmanCodes);*/
       byte[] zip = huffmanZip(bytes);
        for (Byte b:zip) {
            System.out.println(b);

        }
    }
    private static List<Node> getNodes(byte[] bytes) {

        //1创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();

        //遍历 bytes , 统计 每一个byte出现的次数->map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { // Map还没有这个字符数据,第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        //遍历map
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;

    }

    public static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node nodeLeft=nodes.get(0);
            Node nodeRight=nodes.get(1);
            Node parent=new Node(null,nodeLeft.weight+nodeRight.weight);
            parent.leftNode=nodeLeft;
            parent.rightNode=nodeRight;
            nodes.remove(nodeLeft);
            nodes.remove(nodeRight);
            nodes.add(parent);
        }
        return    nodes.get(0);
    }

    public static void preOrder(Node node){
        if(node!=null){
            node.preOrder();
        }
    }

    //为了调用方便  我们重载该方法
    private static Map<Byte, String> getCodes(Node root){
        if(root==null){
            return null;
        }
        //左边
        getCodes(root.leftNode,"0",stringBuilder);
        getCodes(root.rightNode,"1",stringBuilder);
        return huffmanCodes;

    }
    //压缩方法,根据一个byte数组 和他的huffmanCodes 压缩为一个byte数组
    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder sb=new StringBuilder();
        for (Byte b:bytes) {
            String s = huffmanCodes.get(b);
            sb.append(s);
        }
        int len=0;
        if( sb.length()%8==0){
            len=sb.length()/8;
        }else {
            len=sb.length()/8+1;
        }
        int index=0;
        byte[] huffmanBytes=new byte[len];
        for (int i = 0; i < sb.length(); i+=8) {
            String str;
            if(i+8>sb.length()){
                str= sb.substring(i);
            }else{
                str= sb.substring(i,i+8);
            }
            huffmanBytes[index]= (byte)Integer.parseInt(str, 2);
            index++;
        }
        return huffmanBytes;
    }
    //生成赫夫曼树对应的赫夫曼表
    //生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010,
    static Map<Byte,String> huffmanCodes=new HashMap<Byte,String>();
    static StringBuilder stringBuilder=new StringBuilder();
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
            StringBuilder stringBuilder2=new StringBuilder(stringBuilder);
            stringBuilder2.append(code);
        if(node.data==null){

            //向左递归
            getCodes(node.leftNode,"0",stringBuilder2);
            //向右递归
            getCodes(node.rightNode,"1",stringBuilder2);
        }else {
            //为空,说明是叶子节点
            huffmanCodes.put(node.data,stringBuilder2.toString());
        }

    }
    //使用一个方法，将前面的方法封装起来，便于我们的调用.
    /**
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 是经过 赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        byte[] zip = zip(bytes, huffmanCodes);
        return zip;
    }

    /**
     *
     * @param flag  表示是否需要补高位,true是需要   false是不需要
     * @param b 将要被转换的byte
     * @return
     */
    private static String byteToBitString(boolean flag,byte b){
        int temp=b;
        if(flag){
            temp|=256;
        }
        String str=Integer.toBinaryString(temp);
        if(flag){
           return str.substring(str.length() - 8);

        }else {
            return str;
        }

    }
}





class Node implements Comparable<Node>{

    Byte data;
    int weight;
    Node leftNode;
    Node rightNode;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    //前序排列
    public void preOrder(){
        System.out.println(this);
        if(this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if(this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }
}