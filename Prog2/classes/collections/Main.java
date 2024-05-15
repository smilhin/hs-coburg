package generics.tutorial.kartenspiel;

import java.security.interfaces.ECPrivateKey;

public class Main {

    public static void main(String[] srg) {
        Person p1 = new Person("Hans", "Meyer", 41);
        Person p2 = new Person("Peter", "Art", 34);
        Person p3 = new Person("Julia", "Tut", 33);
        Person p4 = new Person("Franz", "Mut", 65);
        Person p5 = new Person("Josef", "Gut", 18);


        BinarySearchTree<Person> tree = new BinarySearchTree<Person>(1, p1); //wurzel
        tree.insert(10, p2); //rightChild
        tree.insert(8, p3); //leftChild von 10
        tree.insert(13, p4); //rightChild von 10
        tree.insert(5, p5);  //leftChild von 8

        System.out.println(tree.search(13));

    }

}
