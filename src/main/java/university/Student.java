package university;

import university.exceptions.EmptySubjectsListException;
import university.exceptions.IllegalMarkException;

import java.util.*;

public class Student {
    private String surname;
    Map<String, Integer> subjects = new HashMap<String, Integer>();

    Student(String name, String[] subj) {
        this.surname = name;

        for (String str : subj) {
            this.subjects.put(str, 0);
        }

    }

    Student(Student student, String[] subj) {
        for (String str : subj) {
            student.subjects.put(str, 0);
        }
    }

    public String getSurname() {
        return surname;
    }

    void passExam() throws IllegalMarkException {
        Random random = new Random();
        Integer mark = random.nextInt(11) - 1;
        for (String subj : this.subjects.keySet()) {
            while (mark < 0 || mark > 10) {
                throw new IllegalMarkException(mark);
            }
            subjects.put(subj, mark);
        }
    }

    double getAverage() {
        int num = subjects.size();
        double out = 0.0;
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            out += entry.getValue();
        }
        return out / num;
    }

    void excludeSubjects(String subj) throws EmptySubjectsListException {
        subjects.remove(subj);
        if (subjects.isEmpty()) {
            throw new EmptySubjectsListException();
        }

    }
}
