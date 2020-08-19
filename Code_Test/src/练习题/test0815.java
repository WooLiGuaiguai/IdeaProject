package 练习题;

import java.io.File;

class Annoyance extends Exception {
}
class Sneeze extends Annoyance {
}

public class test0815 {
    public static void main(String[] args) throws Exception {
        /*try {
            try {
                throw new 练习题.Sneeze();
            }
            catch ( 练习题.Annoyance a ) {
                System.out.println("Caught 练习题.Annoyance");
                throw a;
            }
        }
        catch ( 练习题.Sneeze s ) {
            System.out.println("Caught 练习题.Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }*/
        showDirectory(new File("C:\\Users\\83618\\Desktop\\timu"));
    }
        public static void showDirectory(File f) {
            _walkDirectory(f, 0);
        }
        private static void _walkDirectory(File f, int level) {
            if(f.isDirectory()) {
                for (File temp : f.listFiles()) {
                    _walkDirectory(temp, level + 1);
                }
            } else {
                for (int i = 0; i < level - 1; i++) {
                    System.out.print("t");
                }
                System.out.println(f.getName());
            }
        }

}
