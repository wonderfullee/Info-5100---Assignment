package class10.Assignment_8.class9;

import java.util.List;

public interface StudentsManager {
    void addStudent(class9.Student student);

    void deleteStudent(String rollNumber);

    class9.Student findStudent(String rollNumber);

    void modifyGrade(String rollNumber, String grade);

    void displayStudents();

    List<class9.Student> getStudents();
}