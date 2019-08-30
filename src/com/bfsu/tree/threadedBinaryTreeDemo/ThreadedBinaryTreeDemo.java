package com.bfsu.tree.threadedBinaryTreeDemo;

public class ThreadedBinaryTreeDemo {


    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode(root);

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1
        threadedBinaryTree.threadList();
    }
}

class ThreadedBinaryTree{

    private HeroNode root;
    private HeroNode pre;

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

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
//编写对二叉树进行中序线索话的方法
    /**
     *
     * @param node  待中序线索话的节点
     */
    public void threadedNode(HeroNode node){
        if(node==null){
            //System.out.println("二叉树为空!");
            return;
        }
        //左
        threadedNode(node.getLeft());
        //中
        if(node.getLeft()==null){
            //左子树为空,才可以进行线索话,设置前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre!=null&&pre.getRight()==null){
            //设置后继节点是在下一次递归出设置的
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        //右
        threadedNode(node.getRight());
    }
    //遍历线索化二叉树的方法
    public void threadList(){
        HeroNode node=root;
        while (node!=null){

            while(node.getLeftType()==0){
                //一直往下找,找到最底层的左边
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                //找他的后继节点/如果是就  循环输出
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();


        }
    }

}
class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //代表左子树和右子树的类型
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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