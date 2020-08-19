package MVC;

public class MVCPatternDemo {
    public static void main(String[] args) {
        //从数据库获取学生信息
        Student model=getItem();
        //创建第一个视图,将学生信息更新到控制台
        StudentView view=new StudentView();
        StudentController controller=new StudentController(model,view);
        controller.updateView();

        //更新模型数据
        controller.setStudentName("1008611");
        controller.updateView();
    }
    private static Student getItem(){
        Student stu1=new Student();
        stu1.setName("alibaba");
        stu1.setRollNo("001");
        return stu1;
    }
}
