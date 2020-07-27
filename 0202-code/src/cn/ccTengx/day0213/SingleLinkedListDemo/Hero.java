package cn.ccTengx.day0213.SingleLinkedListDemo;

public class Hero {
    public int number;
    public String name;
    public String nickname;
    public Hero next;

    public Hero() {
    }

    public Hero(int number, String name, String nickname) {
        this.number = number;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
