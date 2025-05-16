public class Main {

    public static  void main(String[] args) {
        Problem problem = new VacuumProblem("RoomA", true, false);
        State current = problem.getInitialState();

        System.out.println("Startzustand: " + current);

        while (!problem.isGoal(current)) {
            VacuumState vs = (VacuumState) current;
            String action;

            // Wähle Aktion basierend auf aktuellem Zustand
            if (vs.getPosition().equals("RoomA") && vs.isRoomADirty()) {
                action = "Suck";
            } else if (vs.getPosition().equals("RoomB") && vs.isRoomBDirty()) {
                action = "Suck";
            } else if (vs.getPosition().equals("RoomA")) {
                action = "GoRoomB";
            } else {
                action = "GoRoomA";
            }
            System.out.println("Aktion → " + action);
            current = problem.getResult(current, action);
            System.out.println("Neuer Zustand: " + current + "\n");
        }
    }

}
