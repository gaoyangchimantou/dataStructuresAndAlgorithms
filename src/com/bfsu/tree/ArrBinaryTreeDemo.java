package com.bfsu.tree;
//顺序存储二叉树
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
       /* int[] arr = { 1, 2, 3, 4, 5, 6, 7 };*/
        int[] arr = { 1, 3,6,8,10,14 };
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
        System.out.println("================================================");
        arrBinaryTree.infixOrder(0);
        System.out.println("================================================");
        arrBinaryTree.postOrder(0);
    }


}
class ArrBinaryTree{

    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr=arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    /**
     *
     * @param index 表示数组的下标
     *  前序遍历
     *  2n+1 左子节点
     *  2n+2 右子节点
     *    n-1/2  父节点
     *
     */
    public void preOrder(int index){

        if(arr==null&&arr.length==0){
            System.out.println("数组为空,不能遍历数组!");
        }
        System.out.println(arr[index]);
        if((2*index)+1<arr.length){
            preOrder((2*index)+1);
        }
        if((2*index)+2<arr.length){
            preOrder((2*index)+2);
        }
    }



    public void infixOrder(int index){

        if(arr==null&&arr.length==0){
            System.out.println("数组为空,不能遍历数组!");
        }
        if((2*index)+1<arr.length){
            infixOrder((2*index)+1);
        }
        System.out.println(arr[index]);
        if((2*index)+2<arr.length){
            infixOrder((2*index)+2);
        }
    }


    public void postOrder(int index){

        if(arr==null&&arr.length==0){
            System.out.println("数组为空,不能遍历数组!");
        }
        if((2*index)+1<arr.length){
            postOrder((2*index)+1);
        }

        if((2*index)+2<arr.length){
            postOrder((2*index)+2);
        }
        System.out.println(arr[index]);
    }
}