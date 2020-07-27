package 图的练习.Mappp;

import java.util.ArrayList;
import java.util.List;

public class MapDemoTest {
    public static void main(String[] args) {
        MapDemo graph = createGraph(false);
        System.out.println("图的矩阵如下：");
        graph.print();
    }
    public static MapDemo createGraph(boolean direction) {
        String[] citys = new String[] { "北京", "上海", "广州", "重庆", "武汉", "南昌" };

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge("北京", "广州", 10));
        edgeList.add(new Edge("北京", "上海", 11));
        edgeList.add(new Edge("上海", "南昌", 6));
        edgeList.add(new Edge("广州", "重庆", 14));
        edgeList.add(new Edge("广州", "武汉", 9));
        edgeList.add(new Edge("重庆", "武汉", 20));
        edgeList.add(new Edge("武汉", "北京", 13));
        edgeList.add(new Edge("武汉", "南昌", 12));
        edgeList.add(new Edge("南昌", "广州", 18));

        Edge[] edgeArray = new Edge[edgeList.size()];

        return new MapDemo(citys, edgeList.toArray(edgeArray), true);
    }
}
