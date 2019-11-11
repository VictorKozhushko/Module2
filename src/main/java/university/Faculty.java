package university;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    String department;
    List<Group> groupList = new ArrayList<Group>() ;

    Faculty(String department, Group[] groups){
        this.department=department;
        for (Group grp: groups)
        {
            groupList.add(grp);
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Faculty(String department, Group group) {
        this.department = department;
        groupList.add(group);
    }

    void excludeGroup(Group group) throws EmptyFaculty{
        groupList.remove(group);
        if (groupList.isEmpty())
            throw new EmptyFaculty();
    }
}