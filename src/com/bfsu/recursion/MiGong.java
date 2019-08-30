package com.bfsu.recursion;

public class MiGong {

    public static void main(String[] args) {

        int[][] map = new int[8][7];
        //����ǽ
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
        System.out.println("��ӡ��ʼ����ĵ�ͼ...");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //

        setWay(map,1,1);

        System.out.println("��ӡѰ�Һ�ĵ�ͼ...");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    //ʹ�õݹ��������С����·,˵��
    //map��ʾ��ͼ  ij��ʾ�ӵ�ͼ���ĸ������  ���С�����ҵ�map[6][5]��ʾС���ҵ�ͨ·
    //Լ�� ��map[i][j]==0ʱ��ʾ�õ�û���߹�  1ʱ��ʾ��ǽ  2 ��ʾ������ͨ 3��ʾ�߹������߲�ͨ
    //���Թ�ʱ���Ƕ��µĲ���:��--->��--->��--->�� �ķ�ʽ����  ����õ��߲�ͨ �ٻ���
    //����:--->�����·������  ��ȫ���Ĳ���(4*3*2*1)�ó���·��(������һ��list����һ�����Ե����нڵ�,���ȽϽڵ������,
    // ������С��,������·�����!)
    /**
     *
     * @param map ��ͼ
     * @param i ��ʼ������
     * @param j ��ʼ������
     * @return
     */

    //ʹ�õݹ�������
    public static boolean setWay(int[][] map, int i, int j) {

        if(map[6][5]==2){
            //��ʾ�Ѿ��ҵ�����
            return true;
        }
        if(map[i][j]==0){
            //��ʾ�õ㻹û���߹�
            //�ȼ���õ������ͨ  ��:
            map[i][j]=2;
            //����������
            if(setWay(map,i+1,j)){
                return true;
                //y��
            }else if(setWay(map,i,j+1)){
                return true;
                //��
            }else if(setWay(map,i-1,j)){
                return true;
                //��
            }else if (setWay(map,i,j-1)){
                return  true;
            }else{
                map[i][j]=3;
                return false;
            }
        }else{
            //==1 2 3
            //1 �õ���ǽ   2 �õ��Ѿ��߹� ��������  3�õ��Ѿ��߹����߲�ͨ
            return false;
        }

    }
}
