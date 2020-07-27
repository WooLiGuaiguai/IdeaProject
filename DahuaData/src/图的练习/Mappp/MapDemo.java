package 图的练习.Mappp;

public class MapDemo {
    int size;
    int[][] matrix;
    String[] Arrays;//给定一个数组 转化成图
    public MapDemo(String[] Arrays, Edge[] edges, boolean direction) {//direction  true代表构建有向图，false代表无向图
        this.Arrays = Arrays;
        this.size = Arrays.length;
        matrix = new int[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(i==j) {
                    matrix[i][j] = 0;
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (Edge e : edges) {
            int begin = findIndex(e.begin, Arrays);
            int end = findIndex(e.end, Arrays);
            matrix[begin][end] = e.weight;
            if (!direction) {
                matrix[end][begin] = e.weight;
            }
        }
    }
    //找出指定数组中某个元素的位置，如果找不到，则返回-1
    public int findIndex(String array, String[] Arrays) {
        for (int i = 0; i < Arrays.length; i++) {
            if (array.equals(Arrays[i]))
                return i;
        }
        return -1;
    }
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            int[] ii = matrix[i];
            System.out.print(Arrays[i] + "  ");
            for (int j : ii) {
                System.out.printf("%-16d", j);
            }
            System.out.println();
        }
    }
    //DFS


}
