package cn.ccTengx.ArrayListest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListest {
    public static void main(String[] args) {
        //和数组相比 ArrayList集合的长度是可以变化的
        //ArrayList<E> list = new ArrayList<String>( ); E代表泛型 只能是引用类型 右边尖括号可以省略
        ArrayList<String> array=new ArrayList<>();
        //对于ArrayList集合来说，直接打印得到的是内容为空的中括号
        System.out.println(array);//[]
        array.add("达芬奇");
        array.add("梵高");
        System.out.println(array);//[达芬奇, 梵高]

        ArrayList<Integer> arrayList=new ArrayList<>();
        Random random=new Random();
        int number=0;
        for (int i = 0; i < 6; i++) {
            number=random.nextInt(33)+1;
            System.out.print(number+"  ");
            arrayList.add(number);
        }
        System.out.println();
        System.out.println("遍历这个集合：");
        for (int j = 0; j < arrayList.size(); j++) {
            System.out.print(arrayList.get(j)+"  ");
        }
        System.out.println();
        System.out.println("=====================");
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student("aaa",20,"man"));
        students.add(new Student("bbb",20,"man"));
        students.add(new Student("ccc",20,"woman"));
        System.out.println(students);
        for (int j = 0; j < students.size(); j++) {
            Student stu=students.get(j);
            System.out.println("name="+stu.getName()+" number:"+stu.getNumber()+" sex："+stu.getSex());
        }
        System.out.println("=====================");
        /*
        * 用一个大集合存入20个随机数(限制在60以内)，然后筛选其中的偶数元素，放到小集合里面
        * 自定义方法实现筛选操作
        * */
        ArrayList<Integer> List=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int num=random.nextInt(60);
            List.add(num);
        }
        System.out.println("遍历big集合：");
        for (int m=0;m<List.size();m++){
            System.out.print(List.get(m)+"  ");
        }
        System.out.println();
        ArrayListest ts=new ArrayListest();
        ArrayList<Integer> List2=ts.getsmall(List);//小集合
        System.out.println("遍历小集合：");
        for (int m=0;m<List2.size();m++){
            System.out.print(List2.get(m)+"  ");
        }
    }
    public ArrayList<Integer> getsmall(ArrayList<Integer> list){
        ArrayList<Integer> list2=new ArrayList<>();//小集合
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2==0){
                list2.add(list.get(i));
            }
        }
        return list2;
    }
}
