package 笔试;

import java.io.*;

public class OPPO {
    public static void main(String[] args) {



        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\readme.md"), "UTF-8"));
            String line = null;
            while( ( line = br.readLine() ) != null ) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
