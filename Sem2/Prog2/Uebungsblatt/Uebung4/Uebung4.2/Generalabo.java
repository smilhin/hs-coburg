public class Generalabo extends Ticket{

    String name;
    String datum;

    public Generalabo(float preis, String name, String datum) {
        super(preis);
        this.name = name;
        this.datum = datum;
    }
    public String getName() {return this.name;}
    public String getDatum() {return this.datum;}

    @Override
    public boolean gueltigInZone(Zone zone) {
        return true;
    }


    @Override
    public void entwerten() {
        isEntwertet = false;
    }

    public String toString() {
        return "Generalabo [inhaber=" + this.name + ", verfallsDatum=" + this.datum + ", preis=" + this.preis + ", entwertet=" + isEntwertet + "]";

    }
}
