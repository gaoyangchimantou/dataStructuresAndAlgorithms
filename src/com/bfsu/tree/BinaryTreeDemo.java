package com.bfsu.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
//先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "sss");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
       node3.setLeft(node5);
        binaryTree.setRoot(root);
      /*  binaryTree.preOrder();
        binaryTree.infixOrder();
        binaryTree.postOrder();*/
        /*HeroNode heroNode = binaryTree.preOrderSearch(5);
        System.out.println(heroNode);*/
       /* System.out.println("删除前..");
        binaryTree.preOrder();
        System.out.println("删除后..");
        binaryTree.delNode(5);
        binaryTree.preOrder();*/
        System.out.println("删除前..");
        binaryTree.preOrder();
        System.out.println("删除后..");
        binaryTree.delNode2(3);
        binaryTree.preOrder();
    }

}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("二叉树为空....");
        }

    }
    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }else{
            System.out.println("二叉树为空....");
        }

    }

    public void postOrder(){
        if(root!=null){
            root.postOrder();
        }else{
            System.out.println("二叉树为空....");
        }

    }


    public HeroNode preOrderSearch(int no){
        if(root!=null){
           return root.preSearch(no);
        }else{
            System.out.println("二叉树为空....");
            return null;
        }
    }
    public HeroNode infixOrderSezrch(int no){
        if(root!=null){
            return root.infixSearch(no);
        }else{
            System.out.println("二叉树为空....");
            return null;
        }
    }

    public HeroNode postOrderSezrch(int no){
        if(root!=null){
            return root.postSearch(no);
        }else{
            System.out.println("二叉树为空....");
            return null;
        }
    }
    public void delNode(int no){
        if(root!=null){
            if(root.getId()==no){
                root=null;
            }else{
                root.delNode(no);
            }
        }else {
            System.out.println("该树为空,无法删除....");
        }
    }
    public void delNode2(int no){
        if(root!=null){
            if(root.getId()==no){
                root=null;
            }else{
                root.delNode2(no);
            }
        }else {
            System.out.println("该树为空,无法删除....");
        }
    }
}


class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //编写 前序遍历 方法
    public void preOrder(){
        //先输出自己
        System.out.println(this);
        //再判断左子节点是否为空,如果不为空,递归调用前序遍历方法
        if(this.getLeft()!=null){
            this.getLeft().preOrder();
        }
        //在判断右子节点是否为空,如果不为空,再递归调用后序遍历方法
        if(this.getRight()!=null){
            this.getRight().preOrder();
        }
    }
    //编写中序遍历方法
    public void infixOrder(){
        //再判断左子节点是否为空,如果不为空,递归调用中序遍历方法
        if(this.getLeft()!=null){
            this.getLeft().infixOrder();
        }
        //输出自己
        System.out.println(this);
        //再判断右子节点是否为空,如果不为空,递归调用中序遍历方法
        if(this.getRight()!=null){
            this.getRight().infixOrder();
        }
    }
    //编写后序遍历方法
    public void postOrder(){

        //再判断左子节点是否为空,如果不为空,递归调用后序遍历方法
        if(this.getLeft()!=null){
            this.getLeft().postOrder();
        }
        //再判断右子节点是否为空,如果不为空,递归调用后序遍历方法
        if(this.getRight()!=null){
            this.getRight().postOrder();
        }
        //输出父节点
        System.out.println(this);

    }

    public HeroNode preSearch(int no){
        if(this.getId()==no){
            return this;
        }
        HeroNode heroNode=null;
        if(this.getLeft()!=null){
            //左递归调用
            heroNode=this.getLeft().preSearch(no);
        }
        if(heroNode!=null){
            return heroNode;
        }
        if(this.getRight()!=null){
            //右递归调用
            heroNode=this.getRight().preSearch(no);
        }
        return heroNode;
    }

    public HeroNode infixSearch(int no){
        HeroNode heroNode=null;
        //先判断左子节点 如果不为空,左子节点 递归调用中序查找
        if(this.getLeft()!=null){
            heroNode=this.getLeft().infixSearch(no);
        }
        if(heroNode!=null){
            return heroNode;
        }
        if(this.getId()==no){
            return this;
        }
        if(this.getRight()!=null){
            heroNode=this.getRight().infixSearch(no);
        }
        return heroNode;
    }
    public HeroNode postSearch(int no){
        //先判断左  然后递归   再右  在递归   在判断父
        HeroNode heroNode=null;
        if(this.getLeft()!=null){
            heroNode=this.getLeft().postSearch(no);
        }
        if(heroNode!=null){
            return heroNode;
        }
        if (this.getRight()!=null){

            heroNode=this.getRight().postSearch(no);
        }
        if(heroNode!=null){
            return heroNode;
        }
        if(this.getId()==no){
            return this;
        }
        return heroNode;
    }

    /**
     * 增加删除节点的方法
     *如果删除的节点是叶子节点,则删除该节点
     *如果删除的节点是非叶子节点,则删除该子书
     *
     *
     * 如果该节点的左子节点是要删除的节点,则就删除
     *  如果该节点的右子节点是要删除的节点,则就删除
     *  否则,就左递归调用删除
     *  否则就右递归调用删除
     *
     */
    public void delNode(int no){
        if(this.left!=null&&this.left.getId()==no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.getId()==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
    /*
    * 课后练习题
    *如果删除的是非叶子节点时  非叶子节点A
    * 1.如果节点A只有一个子节点B,则用B替代A
    * 2.如果节点A有左子节点B和右子节点C,则用左子节点B代替A
    * */
    public void delNode2(int no){
        if(this.left!=null&&this.left.getId()==no){
            //this.left=null;
            //找到了
            if(this.left.left==null&&this.left.right==null){
                //说明该子节点是叶子节点
                this.left=null;
                return;
            }
            if(this.left.left!=null&&this.left.right!=null){
                //该节点有两个子节点
                this.left=this.left.left;
                return;
            }
            if(this.left.left==null&&this.left.right!=null){
                this.left=this.left.right;
                return;
            }
            if(this.left.left!=null&&this.left.right==null){
                this.left=this.left.left;
                return;
            }
            /*return;*/
        }
        if(this.right!=null&&this.right.getId()==no){
            //this.right=null;
           /* return;*/

            if(this.right.left==null&&this.right.right==null){
                //说明该子节点是叶子节点
                this.right=null;
                return;
            }
            if(this.right.left!=null&&this.right.right!=null){
                //该节点有两个子节点
                this.right=this.right.left;
                return;
            }
            if(this.right.left==null&&this.right.right!=null){
                this.right=this.right.right;
                return;
            }
            if(this.right.left!=null&&this.right.right==null){
                this.right=this.right.left;
                return;
            }
        }
        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}