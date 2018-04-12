package class10.Assignment_8.class9;

import java.util.ArrayList;
import java.util.List;

public class StudentsManagerImpl implements StudentsManager {

    private List<class9.Student> students = new ArrayList<class9.Student>();

    @Override
    public void addStudent(class9.Student student) {
        students.add(student);

    }

    @Override
    public void deleteStudent(String rollNumber) {
        class9.Student s = findStudent(rollNumber);
        students.remove(s);

    }

    @Override
    public class9.Student findStudent(String rollNumber) {
        for (class9.Student s : students) {
            if (s.getRoll().equals(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    public List<class9.Student> getStudents() {
        return students;
    }

    @Override
    public void modifyGrade(String rollNumber, String grade) {
        class9.Student s = findStudent(rollNumber);
        s.setGrade(grade);

    }

    @Override
    public void displayStudents() {
        for (class9.Student s : students) {
            System.out.println(s.getLine());
        }

    }

}