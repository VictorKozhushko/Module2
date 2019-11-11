package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    String nameUniversity;
    List<Faculty> facultyList = new ArrayList<Faculty>();

    University(String name, Faculty[] faculties){
        nameUniversity=name;
        for (Faculty faculty: faculties)
        {
            facultyList.add(faculty);
        }
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    double getAveragedUniversity(String subj){

        double markSum=0.;
        int numStudents=0;
        String group = null;
        for (Faculty fac: facultyList) {
            for (Group grp: fac.groupList) {
                for (Student std: grp.students) {
                    if(std.subjects.containsKey(subj) && !grp.getCode().equals(group)) {
                        numStudents += grp.numberStudents();
                        group = grp.getCode();
                    }
                    if(std.subjects.containsKey(subj)){
                        markSum+=std.subjects.get(subj);
                    }
                }
            }
        }
        return markSum/numStudents;
    }

    void passExams(){
        for (Faculty fac: facultyList) {
            for (Group grp: fac.groupList) {
                for (Student std: grp.students) {
                    try {
                        std.passExam();
                    } catch (IllegalMarkException exc)
                    {
                        exc.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        String ecology = "Экология";
        String phylosophy = "Философия";
        String matem = "Мат. анализ";

        String[] course1 = new String[]{"Этика", ecology , phylosophy};

        Student student1 = new Student("Фролов", course1);
        Student student2 = new Student("Бакунин", course1);
        Student student3 = new Student("Сиваков", course1);

        Group phyl1 = new Group("phylosophy",new Student[]{student1, student2, student3});

        Group phys1 = new Group("P1", new String[]{"Механика", ecology, matem}, new String[]{"Яковлев", "Сергиенко", "Бухаров", "Григорьев"});
        Group matem1= new Group("M1", new String[]{matem, ecology, "Информатика"}, new String [] {"Старовойтов", "Парфентьев","Неверов"});
        Group phys2 = new Group("P2", new String[]{"Оптика",phylosophy, matem}, new String[]{"Зайцев", "Прокофьев", "Кузнецов", "Семёнов"});
        Group matem2= new Group("M2", new String[]{"Теория групп", phylosophy, "Дифф.уравн."}, new String [] {"Громыко", "Рокоссовский","Перов"});

        Faculty phylosoph = new Faculty("Ph1",phyl1);
        Faculty matemat = new Faculty("Mathematics", new Group[] {matem1, matem2});
        Faculty physics = new Faculty("Physics", new Group[] {phys1, phys2});

        University skorina = new University("Gomel State University named after Skorina", new Faculty[] {phylosoph, matemat, physics});

        skorina.passExams();

        System.out.println("Averaged of student "+student1.getSurname()+" "+student1.getAverage());
        System.out.println("Averaged of student "+student2.getSurname()+" "+student2.getAverage());
        System.out.println("Averaged of student "+student3.getSurname()+" "+student3.getAverage());

        System.out.println("Averaged over University "+ecology+" "+skorina.getAveragedUniversity(ecology));
        System.out.println("Averaged over University "+phylosophy+" "+skorina.getAveragedUniversity(phylosophy));

        Student student4 = new Student("Иванов", new String[] {ecology, matem, "Аналит. геометрия"});

        try {
            student4.excludeSubjects(ecology);
            student4.excludeSubjects(matem);
            student4.excludeSubjects("Аналит. геометрия");
        } catch (EmptySubjectsList exc)
        {
            exc.printStackTrace();
        }

        try{
            phyl1.excludeStudent(student1);
            phyl1.excludeStudent(student2);
            phyl1.excludeStudent(student3);
        } catch (EmptyGroup exc)
        {
            exc.printStackTrace();
        }

        try{
            phylosoph.excludeGroup(phyl1);
        } catch (EmptyFaculty exc)
        {
            exc.printStackTrace();
        }

    }
}
