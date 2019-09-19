package com.bfsu.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {

       /* int[] arr={4,3,6,5,7,8};*/
       /* int[] arr={10,12,8,9,7,6};*/
        int[] arr={10,11,7,6,8,9};
        AVLTree avlTree=new AVLTree();
        for (int i = 0; i <arr.length ; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println("树的高度为："+avlTree.root.height());
        System.out.println("左子树的高度为"+avlTree.root.leftHeight());
        System.out.println("右子树的高度为"+avlTree.root.rightHeight());
    }

}
class AVLTree{

    Node root;

    public void infixOrder(){

        if(root==null){
            System.out.println("root为空,无法遍历");
        }else{
            root.infixOrder();
        }
    }
    public void add(Node node){
        if(root==null){
            root=node;
        }else {
            root.add(node);
        }
    }
    public Node searchNode(int value){
        if(root==null){
            return null;
        }else{
            return root.searchNode(value);
        }
    }
    public Node  searchParent(int value){
        if(root==null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }
    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点
    /**
     *
     * @param node 传入的节点  当做二叉排序树的根节点
     * @return  返回的以node为根节点的 二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target=node;
        while (target.leftNode!=null){
            target=target.leftNode;
        }
        delNode(target.value);
        return target.value;
    }


    public void delNode(int value){
        if(root==null){
            return;
        }
        Node node = searchNode(value);
        if(node==null){
            return;
        }
        if(root.leftNode==null&&root.rightNode==null){
            root=null;
            return;
        }
        Node parent = root.searchParent(value);
       /* if(parent==null){
            return;
        }*/
        if(node.leftNode==null&&node.rightNode==null){
            //说明将要被删除的节点  是叶子节点
            if(parent.leftNode!=null&&parent.leftNode.value==value){
                parent.leftNode=null;
                return;
            }else if(parent.rightNode!=null&&parent.rightNode.value==value){
                parent.rightNode=null;
                return;
            }
        }else if(node.leftNode!=null&&node.rightNode!=null){
            //说明需要删除的节点  有两颗子树
            int minValue = delRightTreeMin(node.rightNode);
            node.value=minValue;
        }else{
            //说明需要删除的节点只有一颗子树
            if(node.leftNode!=null){
                if(parent!=null){
                    //说明需要删除的节点 有一颗左子树
                    if(parent.leftNode.value==value){
                        parent.leftNode=node.leftNode;
                    }else {
                        parent.rightNode=node.leftNode; }
                }else {
                    root=node.leftNode;
                }
            }else{
                if(parent!=null) {
                    //说明需要删除的节点有一颗右子树
                    if (parent.leftNode.value == value) {
                        parent.leftNode = node.rightNode;
                    } else {
                        parent.rightNode = node.rightNode;
                    }
                }else {
                    root=node.rightNode;
                }
            }
        }
    }

}

class Node {
    int value;
    Node leftNode;
    Node rightNode;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public void infixOrder() {

        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    public void add(Node node) {

        if (this.value > node.value) {
            //
            if (this.leftNode == null) {
                this.leftNode = node;

            } else {
                this.leftNode.add(node);
            }
        } else {
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.add(node);
            }
        }
        if(rightHeight()-leftHeight()>1){
            //如果右子树的左子树的高度大于右子树的右子树，要先对该右子树进行右旋转，在对整体左旋转
            if(rightNode!=null&&rightNode.leftHeight()>rightNode.rightHeight()){
                rightNode.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }
        if(leftHeight()-rightHeight()>1){
          /*  rightRotate();*/
          //如果左子树的右子树大于左子树的左子树   要先进行左旋转，再整体右旋转
            if(leftNode!=null&&leftNode.rightHeight()>leftNode.leftHeight()){
                leftNode.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }

    /**
     * 查找到要删除的节点
     *
     * @param value
     * @return
     */
    public Node searchNode(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.leftNode == null) {
                return null;
            }
            return this.leftNode.searchNode(value);
        } else {
            if (this.rightNode == null) {
                return null;
            }
            return this.rightNode.searchNode(value);
        }
    }

    public Node searchParent(int value) {
        if ((this.leftNode != null && this.leftNode.value == value) || (this.rightNode != null && this.rightNode.value == value)) {
            return this;
        } else if (this.leftNode != null && value < this.value) {
            return this.leftNode.searchParent(value);
        } else if (this.rightNode != null && value >= this.value) {
            return this.rightNode.searchParent(value);
        } else {
            return null;
        }
    }

    /**
     * 返回 以当前节点 为根节点的树的高度
     *
     * @return
     */
    public int height(){

        return Math.max((leftNode==null?0:leftNode.height()),(rightNode==null?0:rightNode.height()))+1;

    }

    /**
     * 返回左子树的高度
     * @return
     */
    public int leftHeight(){
        if(leftNode==null){
            return 0;
        }else {
            return leftNode.height();
        }
    }

    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight(){
        if (rightNode==null){
            return 0;
        }else {
            return rightNode.height();
        }
    }
    //左旋转方法
    private void leftRotate(){

        Node newNode=new Node(value);
        newNode.leftNode=leftNode;
        newNode.rightNode=rightNode.leftNode;
        value=rightNode.value;
        rightNode=rightNode.rightNode;
        leftNode=newNode;
    }
    //右旋转
    private void rightRotate(){
        Node node=new Node(value);
        node.rightNode=rightNode;
        node.leftNode=leftNode.rightNode;
        value=leftNode.value;
        leftNode=leftNode.leftNode;
        rightNode=node;

    }
}