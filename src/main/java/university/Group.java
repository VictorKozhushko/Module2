package university;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String code;
    List<Student> students = new ArrayList<Student>();

    Group(String code, String[] subj, String[] stud) {
        this.code = code;
        for (String std : stud) {
            this.students.add(new Student(std, subj));
        }
    }

    Group(String code, Student[] students){
        this.code = code;
        for ( Student stud: students) {
            this.students.add(stud);
        }
    }

    void add(Student stud) {
        students.add(stud);
    }

    void add(Student[] stds) {
        for (int i = 0; i < stds.length; i++) {
            students.add(stds[i]);
        }
    }

    List<Student> getStudents() {
        return students;
    }

    void excludeStudent(Student student) throws EmptyGroup{

        students.remove(student);
        if (students.isEmpty())
            throw new EmptyGroup();
    }

    int numberStudents(){
        return students.size();
    }

    String getCode(){
        return code;
    }

    double getAverage(String subj){
        double mark=0.;

        for (Student std: students) {
            mark+=std.subjects.get(subj);
        }
        int num = students.size();

        return mark/num;
    }


}
