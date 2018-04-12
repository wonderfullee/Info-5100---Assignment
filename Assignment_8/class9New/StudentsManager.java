package class10.Assignment_8.class9New;

import java.util.List;

public interface StudentsManager {
    void addStudent(Student student);

    void deleteStudent(String rollNumber);

    Student findStudent(String rollNumber);

    void modifyGrade(String rollNumber, String grade);

    void displayStudents();

    List<Student> getStudents();
}