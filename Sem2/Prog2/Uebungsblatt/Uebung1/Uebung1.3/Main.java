class Zaehler {

    int einer, zehner;
    public Zaehler(int zehner, int einer) {
        this.einer = einer;
        this.zehner = zehner;
    }

    public void erhoeheUmEins() throws EinerUeberlauf {
        if(this.einer < 9) einer++;
        else throw new EinerUeberlauf();

    }

    public void erhoeheUmZehn() throws Ueberlauf{
        if(this.zehner < 9) zehner++;
        else throw new Ueberlauf();
    }

    public void zaehlen() {
        try {
            erhoeheUmEins();
        }
        catch(EinerUeberlauf e) {
            try {
                this.einer = 0;
                erhoeheUmZehn();
            }
            catch(Ueberlauf k) {
                System.out.println("Zähler größer 99");
                this.einer = 0;
                this.zehner = 0;
            }
        }
    }

    public String toString(){

        return Integer.toString(zehner) + Integer.toString(einer);
    }
}

class Ueberlauf extends Exception {
    public Ueberlauf() {
        super();
    }
}
class EinerUeberlauf extends Exception {
    public EinerUeberlauf() {
        super();
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}