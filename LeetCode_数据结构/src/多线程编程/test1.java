package 多线程编程;

public class test1 {
    public static void main(String[] args) {
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName());
        Helper helper=new Helper("ali");
        helper.run();
    }
    static class Helper implements Runnable{
        private final String message;
        public Helper(String message){
            this.message=message;
        }
        public void dosomething(String message){
            Thread thread=Thread.currentThread();
            String name=thread.getName();
            System.out.println(name);
        }

        @Override
        public void run() {
            dosomething(message);
        }
    }

}
