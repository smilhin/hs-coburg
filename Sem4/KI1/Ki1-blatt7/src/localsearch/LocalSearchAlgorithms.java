package localsearch;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class LocalSearchAlgorithms {
    public static <P extends ProblemState<P>> P hillClimb(P state) {
        P smallestValueState = state;
        ArrayList<P> states = new ArrayList<>(state.getSuccessors());

        if(state.evaluate() == 28) {
            System.out.println(state.evaluate());
            return state;
        }
        else {
            for (P s : states) {
                smallestValueState = s.evaluate() > state.evaluate() ? s : smallestValueState;
            }
            return hillClimb(smallestValueState);
        }
    }

    public static <P extends ProblemState<P>> P hillClimbSideways(P state, int max) {
        P smallestValueState = state;
        int count = 0;

        while(smallestValueState.evaluate() < 28 && count <= max) {
            ArrayList<P> states = new ArrayList<>(smallestValueState.getSuccessors());
            for (P s : states) {
                System.out.println(s.evaluate() + " " + smallestValueState.evaluate());
                smallestValueState = s.evaluate() > smallestValueState.evaluate() ? s : smallestValueState;
                if(smallestValueState.evaluate() == 28) break;
            }
            System.out.println(count);
            count++;
        }

        return smallestValueState;
    }

    public static <P extends ProblemState<P>> P simulatedAnnealing(P state) {
        return null;
    }
}
