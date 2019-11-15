package university;

import university.exceptions.EmptyFacultyException;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    String department;
    List<Group> groupList = new ArrayList<Group>();

    Faculty(String department, Group[] groups) {
        this.department = department;
        for (Group grp : groups) {
            groupList.add(grp);
        }
    }

    public String getFaculty() {
        return department;
    }

    public void setFaculty(String department) {
        this.department = department;
    }

    public Faculty(String department, Group group) {
        this.department = department;
        groupList.add(group);
    }

    void excludeGroup(Group group) throws EmptyFacultyException {
        groupList.remove(group);
        if (groupList.isEmpty())
            throw new EmptyFacultyException();
    }
}