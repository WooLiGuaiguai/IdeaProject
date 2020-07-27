package cn.ccTengx.day0213.CollectionsDemo;

public class Person implements Comparable<Person>{
    private int num;
    private String name;
    private  String nickname;

    public Person(int num, String name, String nickname) {
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public int compareTo(Person o) {
        //自定义比较规则
        return this.getNum()-o.getNum();
    }
}
