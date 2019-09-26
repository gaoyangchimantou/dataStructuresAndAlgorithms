package com.bfsu.graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private List<String> vertexList;//存储节点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//存储边的数目
    private boolean[] isVisited;//记录节点是否被访问过的集合

    public static void main(String[] args) {
        //测试一把   图的创建
        int n=5;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for(String vertex: Vertexs) {
            graph.insertVertex(vertex);
        }

    //添加边
            //A-B A-C B-C B-D B-E
    		graph.insertEdge(0, 1, 1); // A-B
    		graph.insertEdge(0, 2, 1); //
    	    graph.insertEdge(1, 2, 1); //
    		graph.insertEdge(1, 3, 1); //
    		graph.insertEdge(1, 4, 1); //
        //显示一把邻结矩阵
        graph.showGraph();
        //graph.dfs();
        graph.bfs();
    }

    //构造函数
    public Graph(int n){
        vertexList=new ArrayList<String>(n);
        edges=new int[n][n];
        numOfEdges=0;
        isVisited=new boolean[n];
    }

    //插入节点的方法
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //加入边的方法

    /**
     *
     * @param v1 表示点的下标 即表示第几个顶点  A--》0  b---->1
     * @param v2
     * @param weight  1表示可以直连  0表示不可以直连
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回边的个数
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点I对应的数据  0----》A
    public String getValueByIndex(int index){

        return vertexList.get(index);
    }
    //返回V1 V2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
//int[][] edges
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //获得第一个 邻接节点的坐标
    public int getFirstNeighbor(int index){
        for (int j = 0; j <vertexList.size() ; j++) {
            if(edges[index][j]>0){

                return j;
            }
        }

        return -1;
    }
    //获得该节点的邻接节点的下一个节点的坐标
    public int getNextNeighbor(int v1,int v2){
        for (int j = v2+1; j <vertexList.size() ; j++) {
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }


    public void dfs(boolean[] isVisited,int index){
        boolean flag= isVisited[index];
        if(!flag){
            System.out.print(vertexList.get(index)+"-->");
            isVisited[index]=true;
            int w = getFirstNeighbor(index);
            while (w!=-1){
                //说明i下面有节点w
                if(!isVisited[w]){
                    //说明w没被访问过
                    dfs(isVisited,w);
                }
                w=getNextNeighbor(index,w);
            }
        }
    }
    public void dfs(){

        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    //图的广度优先
    public void bfs(boolean[] isVisited,int i){
        int u;//表示队列的头结点的下标
        int w;//表示邻接节点
        LinkedList queue=new LinkedList();
        System.out.println(vertexList.get(i)+"--->");
        isVisited[i]=true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u= (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w!=-1){

               if(!isVisited[w]){
                   System.out.println(vertexList.get(w)+"--->");
                   isVisited[w]=true;
                   queue.addLast(w);
               }
                w = getNextNeighbor(u, w);
            }

        }
    }
    //图的广度优先
    public void bfs(){
        for (int i = 0; i <vertexList.size() ; i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

}
