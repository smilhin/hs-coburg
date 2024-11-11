import java.util.ArrayList;


public class SeminarClass implements Seminar {

    private final ArrayList<Student> students;
    private int numberOfStudents;
    private final int maxSize;

    SeminarClass(int numberOfStudents) {
        students = new ArrayList<Student>(numberOfStudents);
        this.numberOfStudents = 0;
        this.maxSize = numberOfStudents;
    }

    public void signIn(Student student) {
        if(isSignedIn(student)) {
            System.out.println("Student already signed in!");
        }
        else {
            if(numberOfStudents >=maxSize) {
                System.out.println("Seminar is full!");
            }
            else {
                students.add(student);
                numberOfStudents++;
            }
        }
    }
    public boolean isSignedIn(Student student) {
       for(Student f_student : students) {
           if(f_student.equals(student)) {
               return true;
           }
       }
       return false;
    }

    public int numberOfStudents() {
        return numberOfStudents;
    }
    public String getStudents() {
        StringBuilder result = new StringBuilder();
        for(Student f_student : students) {
            result.append(f_student.getName()).append("\n");
        }
        return result.toString();
    }

}
