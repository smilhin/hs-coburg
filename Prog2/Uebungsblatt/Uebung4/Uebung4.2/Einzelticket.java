public class Einzelticket extends Ticket{


    String datum;
    Zone zone;
    public Einzelticket(float preis, String datum, Zone zone) {
        super(preis);
        this.datum = datum;
        this.zone = zone;
    }
    @Override
    public boolean gueltigInZone(Zone zone) {
        return this.zone == zone;
    }

    public String getDatum() {
        return this.datum;
    }

    public Zone getZone() {
        return this.zone;
    }

    public String toString() {
        return "Einzelticket [zone=" + this.zone + ", verfallsDatum=" + this.datum + ", preis=" + this.preis + ", entwertet=" + isEntwertet + "]";
    }
}
