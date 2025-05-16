import java.util.Arrays;


public class Main {



    public static void main(String[] s) {

        Ticket t = new Einzelticket(3.5f, "12.6.2023", Ticket.Zone.A);
        System.out.println(t);

        Ticket t1 = new Generalabo(250, "Peter Mustermann", "31.12.2030");
        System.out.println(t1);
        Ticket t2 = new Mehrfahrtenticket(9.5f, 10, Ticket.Zone.C);
        System.out.println(t2);


    }
} // 