package 代码原理测试;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class Operate{
    //序列化方法
    public void serializable(Person person) throws FileNotFoundException, IOException{
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("E:\\IdeaProject\\IdeaProject\\Code_Test\\src\\a.txt"));
        outputStream.writeObject(person);
    }

    //反序列化的方法
    public Person deSerializable() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\IdeaProject\\IdeaProject\\Code_Test\\src\\a.txt"));
        return (Person) ois.readObject();
    }
}
class Person implements Externalizable{
    private static final long serialVersionUID=1L;
    String username="阿泰斯特";
    String password;
    int age;

    public Person(){super();}
    public Person(String username,String password,int age){
        super();
        this.username=username;
        this.password=password;
        this.age=age;
    }


    //序列化操作扩展类
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //增加一个新的对象
        Date date=new Date();
        out.writeObject(username);
        out.writeObject(password);
        out.writeObject(date);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        username=(String)in.readObject();
        password=(String) in.readObject();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=(Date)in.readObject();
        System.out.println("反序列化后的日期"+sdf.format(date));
    }
    public String toString() {
        //注意这里的年龄是不会被序列化的，所以在反序列化的时候是读取不到数据的
        return "用户名:阿翔"+username+"  密 码:"+password+"  年龄:"+age;
    }
}
public class Test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Operate operate=new Operate();
        Person person=new Person("","123456",20);
        System.out.println("为序列化之前的相关数据如下:\n"+person.toString());
        operate.serializable(person);
        Person newPerson=operate.deSerializable();
        System.out.println("-------------------------");
        System.out.println("序列化之后的相关数据如下:\n"+newPerson.toString());
    }

        }
