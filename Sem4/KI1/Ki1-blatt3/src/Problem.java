import java.util.List;

public interface Problem {
    State getInitialState();
    boolean isGoal(State s);

    List<String> getActions(State s);

    // Gibt den Folgezustand zurück, wenn eine Aktion angewendet wird
    State getResult(State s, String action);
}
