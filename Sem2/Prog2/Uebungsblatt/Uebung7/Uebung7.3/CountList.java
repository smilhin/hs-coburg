import com.sun.jdi.Value;

import java.util.*;

public class CountList<E> extends LinkedList<E> {


    public CountList() {

    }
    public int count(E element) {
        int result = 0;

        for(E el : this) {
            if(el.equals(element)) {
                result++;
            }
        }

        return result;
    }

    public int unique() {
        int unique = 0;
        CountList<E> newList = new CountList<E>();

        for(E el : this) {
            if(!newList.contains(el)) {
                newList.add(el);
            }
        }
        return newList.size();

    }
    public Map<E, Integer> counts() {

        Map<E, Integer> count = new HashMap<E, Integer>();
        CountList<E> newList = new CountList<E>();

        for(E el : this) {
            if(!newList.contains(el)) {
                newList.add(el);
            }
        }

        for(E el1 : newList) {
            int counter = 0;
            for(E el2 : this) {
                if(el1.equals(el2)) {
                    counter++;
                }
            }
            count.put(el1, counter);
        }


        return count;

    }
}
