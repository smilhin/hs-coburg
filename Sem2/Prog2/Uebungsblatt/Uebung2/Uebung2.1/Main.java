import java.util.Arrays;

class prog {

    public static void main(String[] s) {
        Integer[] array = { 2000, 2, 45, 34, 100000, 345, 56, 78, 99, 756, 999, 0, 666, 2345, 7492, 22 };

        // Ausgabe unsortiertes Array
        System.out.print("Unsortiertes Array :");
            System.out.print(Arrays.toString(array));
        // bubbleSort Aufruf
        System.out.println();
        Integer[] k = bubbleSort(array);
        // Ausgabe sortiertes Array
        System.out.print("Sortiertes Array :");
        System.out.print(Arrays.toString(k));
    }

    public static int[] integerToInt(Integer[] array) {
        int[] newArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static Integer[] intToInteger(int[] array) {
        Integer[] newArray = new Integer[array.length];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static Integer[] bubbleSort(Integer[] array) {

        int[] newArray = integerToInt(array);

        for (int counter = 0; counter < newArray.length; counter++) {
            for (int pass = 0; pass < newArray.length; pass++) {
                for (int element = 0; element < newArray.length - 1 - pass; element++) {
                    if (newArray[element] > newArray[element + 1]) {
                        int temp = newArray[element];
                        newArray[element] = newArray[element + 1];
                        newArray[element + 1] = temp;
                    }
                }
            }
        }

        return intToInteger(newArray);

    }
} // 