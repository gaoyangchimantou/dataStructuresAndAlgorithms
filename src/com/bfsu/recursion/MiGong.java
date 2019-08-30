package com.bfsu.recursion;

public class MiGong {

    public static void main(String[] args) {

        int[][] map = new int[8][7];
        //设置墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("打印初始化后的地图...");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //

        setWay(map,1,1);

        System.out.println("打印寻找后的地图...");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    //使用递归回溯来给小球找路,说明
    //map表示地图  ij表示从地图的哪个点出发  如果小球能找到map[6][5]表示小球找到通路
    //约定 当map[i][j]==0时表示该点没有走过  1时表示是墙  2 表示可以走通 3表示走过但是走不通
    //走迷宫时我们定下的策略:下--->右--->上--->左 的方式来走  如果该点走不通 再回溯
    //进阶:--->求最短路径问题  将全部的策略(4*3*2*1)得出的路径(可以用一个list保存一个策略的所有节点,最后比较节点的数量,
    // 数量最小的,即就是路径最短!)
    /**
     *
     * @param map 地图
     * @param i 初始横坐标
     * @param j 初始纵坐标
     * @return
     */

    //使用递归来调用
    public static boolean setWay(int[][] map, int i, int j) {

        if(map[6][5]==2){
            //表示已经找到出口
            return true;
        }
        if(map[i][j]==0){
            //表示该点还没有走过
            //先假设该点可以走通  即:
            map[i][j]=2;
            //先往下面找
            if(setWay(map,i+1,j)){
                return true;
                //y右
            }else if(setWay(map,i,j+1)){
                return true;
                //上
            }else if(setWay(map,i-1,j)){
                return true;
                //左
            }else if (setWay(map,i,j-1)){
                return  true;
            }else{
                map[i][j]=3;
                return false;
            }
        }else{
            //==1 2 3
            //1 该点是墙   2 该点已经走过 不能再走  3该点已经走过且走不通
            return false;
        }

    }
}
