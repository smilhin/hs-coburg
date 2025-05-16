
import localsearch.LocalSearchAlgorithms;
import localsearch.NQueensProblem;

public class Uebung07 {
    public static void main(String[] args) {

        NQueensProblem prob1 = new NQueensProblem(8, new int[] {5,3,1,8,8,6,8,1});
        NQueensProblem prob2 = new NQueensProblem(8, new int[] {7,2,6,1,1,8,5,3});
        NQueensProblem prob3 = new NQueensProblem(8, new int[] {7,8,2,6,6,1,7,2});

        NQueensProblem prob0 = new NQueensProblem(8);

        NQueensProblem prob = prob1;

      //  System.out.println(LocalSearchAlgorithms.hillClimb(prob));

        NQueensProblem solution = LocalSearchAlgorithms.hillClimbSideways(prob, 25);
        if(solution.evaluate() < 28) {
            System.out.println("Die beste Lösung: " + solution);
            System.out.println("Sich bedrohende Paare:" + (28 - solution.evaluate()));
        }
        else {
            System.out.println("Lösung: " + solution + ", Sich bedrohende Paare: " + (28 - solution.evaluate()));
        }
//        LocalSearchAlgorithms.simulatedAnnealing(prob);
    }}
