
    public class Ort<E> {

        final private int KEY;
        private E value;
        public Ort(int ortsId) {
            KEY = ortsId;
        }
        public E entnehmen() {
            E oldValue = value;
            value = null;
            return oldValue;
        }
        public void hinzufügen(E e) {
            if(!istBelegt()) {
                value = e;
            }
        }
        public boolean istBelegt() {
            return value != null;
        }
        public E getEingelagertesElement() {
            return value;
        }
        public int getOrtsId() {
            return KEY;
        }
        public String toString() {
            return "OrtId:" + KEY + " " + value;
        }


    }


    class OrtTest {


        @SuppressWarnings("unchecked")
        public static Ort<String>[] testEinfuegenEntfernen() {
            String[] arr = { "PC Fujitsu LA 3740", "Miele Waschmaschine ML300" , "Siemens HL 500" , "OSRAM MM 100", "Bosch Rasenmäher HH " };

            Ort<String>[] ortArr = new Ort[5];

            for(int i = 0; i < arr.length; i++) {
                ortArr[i] = new Ort<String>(i);
                ortArr[i].hinzufügen(arr[i]);
            }
            ortArr[0].entnehmen();
            ortArr[2].entnehmen();
            ortArr[4].entnehmen();
            return ortArr;
        }

    }


