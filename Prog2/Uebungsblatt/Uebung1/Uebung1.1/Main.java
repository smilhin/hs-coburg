import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.ParsePosition;


class Birthday {


    String s;

    public Birthday(String s) throws InvalidBirthdayException {
        checkDay(s);
        this.s = s;
    }

    public void checkDay(String s) throws InvalidBirthdayException {

        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(false);
        var myDate = df.parse(s, new ParsePosition(0));

        if (myDate == null) throw new InvalidBirthdayException("Falsches Datum: " + s);
    }

    public String toString() {

        return s;

    }

}
class InvalidBirthdayException extends Exception {
    public InvalidBirthdayException(String errorMessage) {
        super(errorMessage);
    }
}
public class Main {
    public static void main(String[] args) {

    }
}