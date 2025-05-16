public class NumberOfOnes {

public static void main(String[] srg) {

    System.out.println(numberOfOnes(255));
    System.out.println(numberOfOnesModulo(255));

}

static int numberOfOnes(int number) {
    int result = 0;
    for(int i = 0; i < 32; i++) {
        if(((number >> i) & 1) == 1) {
            result++;
        }
    }

    return result;
}

static int numberOfOnesModulo(int number) {

    int result = 0;

    while(number > 0) {
        result += number % 2;
        number /= 2;
    }
    return result;

}


}







