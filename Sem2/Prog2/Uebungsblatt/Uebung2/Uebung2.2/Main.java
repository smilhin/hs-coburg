public class Main {
    public static void main(String[] s) throws CloneNotSupportedException {

        Karte k1 = new Karte(Karte.Farbe.HERZ, Karte.Wert.BUBE);
        Karte k2 = new Karte(k1);

        System.out.println(k2);
    }
}
