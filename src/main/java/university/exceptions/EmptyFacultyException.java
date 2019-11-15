package university.exceptions;

public class EmptyFacultyException extends Exception {
    public EmptyFacultyException() {
        System.out.println("The faculty is Empty");
    }
}
