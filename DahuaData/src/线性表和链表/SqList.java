package 线性表和链表;
//线性表
public class SqList<E> {
    private Object[]data;//存储数据元素
    private int length;//线性表当前长度
    private int maxSize;//数组长度 最大存储空间

    public SqList(){
        data=new Object[20];
        length=0;
        //也可以直接使用 this(20)
    }
    //初始化线性表
    public SqList(int initialSize){
        if(initialSize<0){
            throw new RuntimeException("数组大小为负 初始化失败");
        }
        else{
            this.maxSize=initialSize;
            this.data=new Object[initialSize];
            this.length=0;
            System.out.println("初始化成功");
        }
    }
    //判断是否为空
    public boolean IsEmpty(){
        if(length==0){
            System.out.println("表为空");
            return true;
        }
        System.out.println("表不为空");
        return false;
        //return this.length==0;
    }
    //清空线性表
    public void ClearList(){
        this.length=0;
        System.out.println("表成功清空");
    }
    //获取i位置元素
    public E GetItem(int i){
        if(i<0||i>this.length){
            throw new RuntimeException("i信息不符合规范");
        }
        System.out.println("获取元素成功");
        return (E)data[i];
    }
    //查找元素
    public int LocateItem(E e){
        for (int i=0;i<data.length;i++){
            if (data[i]==e){
                return i;
            }
        }
        System.out.print("查找失败");
        return 0;
    }
    //插入元素
    public boolean InsertList(int i,E e){
        if(i<0||i>=data.length){
            throw new RuntimeException("插入位置有误"+i);
        }
        if(this.length==this.maxSize){
            System.out.println("表已满 无法插入");
            return false;
        }
        for(int j=this.length-1;j>=i;j--){
            this.data[j+1]=this.data[j];
        }
        this.data[i]=e;
        this.length++;
        return true;
    }
    // 删除i位置的元素，并用e返回其值
    public E ListDelete(int i) {
        if(this.length==0) {
            throw new RuntimeException("空表，无法执行删除操作！");
        }
        if(i<0||i>=this.length) {
            throw new RuntimeException("删除位置错误！");
        }
        E e=(E) this.data[i];
        if(i<=this.length-1){
            for(int j=i+1;j<this.length;j++) {
                this.data[j-1]=this.data[j];
            }
        }
        this.length--;
        System.out.println("删除成功！");
        return e;
    }
    //返回线性表的元素个数
    public int ListLength() {
        return this.length;
    }


}
