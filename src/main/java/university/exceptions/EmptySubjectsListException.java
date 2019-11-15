package university.exceptions;

public class EmptySubjectsListException extends Exception {
    public EmptySubjectsListException() {
        System.out.println("Student has no subjects");
    }
}
