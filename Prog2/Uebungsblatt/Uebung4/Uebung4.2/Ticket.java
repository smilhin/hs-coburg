public abstract class Ticket {

    public enum Zone { A, B, C };
    public float preis;
    public boolean isEntwertet = false;

    public Ticket(float preis) {
        this.preis = preis;
    }

    public float getPreis() {

        return this.preis;
    }

    public void entwerten() {
        this.isEntwertet = true;
    }

    public boolean istEntwertet() {
        return this.isEntwertet;
    }

    public void setPreis(float preis) {this.preis = preis;}

    public abstract boolean gueltigInZone(Zone zone);
}
