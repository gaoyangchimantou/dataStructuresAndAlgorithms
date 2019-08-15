package com.bfsu.sparsearray;
//稀疏数组
public class SparseArray {

    public static void main(String[] args) {
        //先初始化原始数组chessArr1 11*11
        //0表示没有棋子 1表示黑色棋子 2表示蓝色棋子
        int chessArr1[][]= new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        //输出原始的二维数组
        for (int[] row:chessArr1){
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum=0;
        for (int[] row:chessArr1){
            for (int data:row) {
                if(data!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum:"+sum);
        // 2. 创建对应的稀疏数组
        // 给稀疏数组赋值

        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        // 遍历二维数组，将非0的值存放到 sparseArr中
        int count=0;
        for (int i=0;i<chessArr1.length;i++){
            for (int j=0;j<chessArr1[i].length;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组的形式
        for (int[] items:sparseArr) {
            for (int data:items) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将稀疏数组--->恢复成原始的二维数组
        /*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */
        int chessArr2[][]= new int[sparseArr[0][0]][sparseArr[0][1]];

       for (int i=1;i<sparseArr.length;i++){
           chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
       }

        System.out.println("经过稀疏数组恢复后的原始二维数组:");
        for (int[] row:chessArr2){
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
