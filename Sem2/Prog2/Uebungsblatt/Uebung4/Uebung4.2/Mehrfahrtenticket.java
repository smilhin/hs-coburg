public class Mehrfahrtenticket extends Ticket{

    int fahrten;
    Zone zone;
    public Mehrfahrtenticket(float preis, int fahrten, Zone zone) {
        super(preis);
        this.fahrten = fahrten;
        this.zone = zone;
    }
    @Override
    public void entwerten() {
        if(this.fahrten > 1) this.fahrten--;
        else {
            isEntwertet = true;
            this.fahrten--;
        }
    }


    @Override
    public boolean gueltigInZone(Zone zone) {
        return this.zone == zone;
    }

    public String toString() {
        return "Mehrfahrtenticket [fahrten=" + this.fahrten + ", zone=" + this.zone + ", preis=" + this.preis + ", entwertet=" + isEntwertet + "]";

    }
}
