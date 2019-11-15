package university.exceptions;

public class IllegalMarkException extends Exception {
    int mark;

    public IllegalMarkException(int mrk) {
        mark = mrk;
    }

    @Override
    public String toString() {
        return "The mark: " + mark + " is out of range 1 to 10\n";
    }
}
