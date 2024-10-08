
public record Karte(Karte.Farbe farbe, Karte.Wert wert) {


    enum Farbe {KREUZ, PIK, HERZ, KARO };
    enum Wert {SIEBEN, ACHT, NEUN, ZEHN, BUBE, DAME, KOENIG, ASS};

    public Karte(Karte k1) {

        this(k1.farbe(), k1.wert());
    }

    }
