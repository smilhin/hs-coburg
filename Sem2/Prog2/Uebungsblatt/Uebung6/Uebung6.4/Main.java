import java.util.*;
public class Main {
    public static void main(String[] args) {

        System.out.println(Utilities.noNull(null, 23, 45, 56, null));
        System.out.println((Object)Utilities.noNull());
        System.out.println(Utilities.noNull(null, "Hello", "WoW"));

    }

}
