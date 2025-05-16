public class Main {

    public static void main(String[] argv) {
        Seminar informatikSeminar = new SeminarClass(8);
        Student student1 = new StudentClass("Meinhard", "Holger");
        Student student2 = new StudentClass("Volkhard", "Pfeiffer");
        Student student3 = new StudentClass("Florian", "Mittag");
        Student student4 = new StudentClass("Mathe", "Horbaschek");
        Student student5 = new StudentClass("Student", "Five");
        Student student6 = new StudentClass("Landes", "Dieter");
        Student student7 = new StudentClass("Student", "Seven");
        Student student8 = new StudentClass("Student", "Eight");
        Student student9 = new StudentClass("Student", "9");
        Student student10 = new StudentClass("Volkhard", "Pfeiffer");

        informatikSeminar.signIn(student1);
        informatikSeminar.signIn(student2);
        informatikSeminar.signIn(student3);
        informatikSeminar.signIn(student10);
        informatikSeminar.signIn(student4);
        informatikSeminar.signIn(student5);
        informatikSeminar.signIn(student6);
        informatikSeminar.signIn(student7);
        informatikSeminar.signIn(student8);
        informatikSeminar.signIn(student9);


        System.out.println(informatikSeminar.getStudents());


    }

}
