public interface Seminar {

    void signIn(Student student);

    boolean isSignedIn(Student student);

    int numberOfStudents();
    String getStudents();

}
