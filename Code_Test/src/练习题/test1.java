package 练习题;

public class test1 {

    private int[] arr;

    public test1() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public test1(test1 original) {
        arr = new int[original.arr.length];
        for (int i = 0; i < original.arr.length; i++) {
            arr[i] = original.arr[i];
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    public static void main(String []args){
        test1 e1 = new test1();
        test1 e2 = new test1(e1);
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 2

    }
}

