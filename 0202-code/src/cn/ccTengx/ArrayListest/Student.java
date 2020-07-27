package cn.ccTengx.ArrayListest;

public class Student {
    private String name;
    private int number;
    private String sex;

    public Student() {
    }

    public Student(String name, int number, String sex) {
        this.name = name;
        this.number = number;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
