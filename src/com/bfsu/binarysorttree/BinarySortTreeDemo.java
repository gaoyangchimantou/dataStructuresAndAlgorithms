package com.bfsu.binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
       /* int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};*/
        int[] arr = {7,1};
        BinarySortTree binarySortTree=new BinarySortTree();
        for (int i = 0; i <arr.length ; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
        //////////////////////////////
      /*  binarySortTree.delNode(12);

        System.out.println("删除结点后");
        binarySortTree.infixOrder();*/
      /*  binarySortTree.delNode(12);*/
        binarySortTree.delNode(7);

        System.out.println("root=" + binarySortTree.root);
        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
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
class Node{
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
    public void infixOrder(){

        if(this.leftNode!=null){
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if(this.rightNode!=null){
            this.rightNode.infixOrder();
        }
    }
    public void add(Node node){

        if(this.value>node.value){
            //
            if(this.leftNode==null){
                this.leftNode=node;

            }else{
                this.leftNode.add(node);
            }
        }else{
            if(this.rightNode==null){
                this.rightNode=node;
            } else {
                this.rightNode.add(node);
            }
        }
    }

    /**
     * 查找到要删除的节点
     * @param value
     * @return
     */
    public Node searchNode(int value){
        if(this.value==value){
            return this;
        }else if(value<this.value){
            if(this.leftNode==null){
                return null;
            }
            return this.leftNode.searchNode(value);
        }else {
            if(this.rightNode==null){
                return null;
            }
          return  this.rightNode.searchNode(value);
        }
    }
    public Node searchParent(int value){
        if((this.leftNode!=null&&this.leftNode.value==value)||(this.rightNode!=null&&this.rightNode.value==value)){
            return this;
        }else if(this.leftNode!=null&&value<this.value){
            return this.leftNode.searchParent(value);
        }else if(this.rightNode!=null&&value>=this.value){
          return   this.rightNode.searchParent(value);
        }else{
            return null;
        }
    }
}