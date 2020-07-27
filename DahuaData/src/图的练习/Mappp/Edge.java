package 图的练习.Mappp;


public class Edge{//如果存储其他元素 直接修改begin的类型即可
    String begin;
    String end;
    int weight;//边的权重

    public Edge(String begin,String end,int weight){
        super();
        this.begin=begin;
        this.end=end;
        this.weight=weight;
    }
}
