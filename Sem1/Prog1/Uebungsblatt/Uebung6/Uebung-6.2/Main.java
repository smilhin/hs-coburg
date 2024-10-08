package Uebungsblatt1;


class Radio {
    public boolean isTurnedOn;
    public int radioVolume;
    public double radioFrequency;

    public Radio(boolean isTurnedOn, int radioVolume, double radioFrequency) {

        this.isTurnedOn = isTurnedOn;
        if(radioVolume <= 10 && radioVolume >= 0) {
            this.radioVolume = radioVolume;
        }
        else {
            this.radioVolume = 0;
        }
        if(radioFrequency >= 85.0 && radioFrequency <= 110.0) {
            this.radioFrequency = radioFrequency;
        }
        else {
            this.radioFrequency = 100.0;
        }

        if(!isTurnedOn) {
            this.radioFrequency = 100.0;
        }

    }
    public String toString() {
        return "Radio: " + isTurnedOn + " Freq= " + radioFrequency + " Laut= " + radioVolume;
    }

    public void an() {
        this.isTurnedOn = true;
    }
    public void aus() {
        this.isTurnedOn = false;
    }
    public void lauter() {
        if(this.radioVolume < 10) this.radioVolume++;
    }

    public void leiser() {
        if(this.radioVolume > 0) this.radioVolume--;
    }
    public void waehleSender(double frequenz) {
        if(frequenz <= 110.0 && frequenz >= 85.0) {
            this.radioFrequency = frequenz;
        }
        else {
            this.radioFrequency = 99.9;
        }
    }

    class RadioTest {

        public static void testTheRadioClass() {
            Radio r = new Radio(true, 5,87.6);
            System.out.println(r);
            r.waehleSender(95.3);
            System.out.println(r);
            r.aus();
            System.out.println(r);
            r.an();
            r.waehleSender(99.6);
            System.out.println(r);
            r.aus();
            System.out.println(r);

        }
    }
    public static void main(String[] args) {

        RadioTest.testTheRadioClass();

    }
}