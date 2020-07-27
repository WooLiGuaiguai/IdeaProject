package cn.ccTengx.day0226;

public @interface MyAnno {
    public abstract  int show1();
    public abstract  String show2();
    String[] show3();
    MyAnno2 show4();
    MyEnum show5();
    char show6() default 'a';
}
