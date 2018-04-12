package class10.Assignment_8.class9New;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StudentsPersistorImpl implements StudentsPersistor {

    //public String file = ReadFromFile.filePath;

    @Override
    public void save(StudentsManager manager) throws Exception {
        File f = new File(ReadFromFile.filePath);
        if (f.exists() == false) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        PrintStream ps = new PrintStream(fos);
        for (Student s : manager.getStudents()) {
            ps.println(s.getLine());
        }
        ps.flush();
        ps.close();
    }

    @Override
    public StudentsManager load() throws Exception {
        File f = new File(ReadFromFile.filePath);
        if (f.exists() == false)
            return new StudentsManagerImpl();
        FileInputStream fis = new FileInputStream(f);
        StudentsManager manager = new StudentsManagerImpl();
        DataInputStream dis = new DataInputStream(fis);
        while (true) {
            String line = dis.readLine();
            if (line == null)
                break;
            Student s = Student.fromLine(line);
            manager.addStudent(s);
        }
        dis.close();
        return manager;
    }

}