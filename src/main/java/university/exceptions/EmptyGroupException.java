package university.exceptions;

public class EmptyGroupException extends Exception {
    public EmptyGroupException() {
        System.out.println("The group is Empty");
    }
}
