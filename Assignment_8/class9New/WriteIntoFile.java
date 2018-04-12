
package class10.Assignment_8.class9New;

import java.io.File;
import java.io.FileOutputStream;

public class WriteIntoFile {

    public static void main(String[] args) throws Exception {
        File f = new File("/Users/sdosapati/indeed/source-candidate-pipeline/.idea/vcs1.xml");
        FileOutputStream fos = new FileOutputStream(f, true);
        String a = "I love Australia\n";
        byte b[] = a.getBytes();
        fos.write(b);
        fos.close();
    }

}