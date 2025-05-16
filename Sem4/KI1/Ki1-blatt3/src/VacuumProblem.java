import java.util.Arrays;
import java.util.List;

public class VacuumProblem implements Problem {

    private final State initial;

    public VacuumProblem(String position, boolean roomADirty, boolean roomBDirty) {
        initial = new VacuumState(position, roomADirty, roomBDirty);
    }

    @Override
    public State getInitialState() {
        return initial;
    }

    @Override
    public boolean isGoal(State s) {
        if (!(s instanceof VacuumState)) return false;
        VacuumState vs = (VacuumState) s;
        return !vs.isRoomADirty() && !vs.isRoomBDirty();
    }

    @Override
    public List<String> getActions(State s) {
        VacuumState vs = (VacuumState) s;
        return Arrays.asList("Suck", "GoRoomA", "GoRoomB");
    }

    @Override
    public State getResult(State s, String action) {
        VacuumState vs = (VacuumState) s;
        String pos = vs.getPosition();
        boolean roomA = vs.isRoomADirty();
        boolean roomB = vs.isRoomBDirty();

        switch (action) {
            case "Suck":
                if (pos.equals("RoomA")) roomA = false;
                else roomB = false;
                break;
            case "GoRoomA":
                pos = "RoomA";
                break;
            case "GoRoomB":
                pos = "RoomB";
                break;
        }
        return new VacuumState(pos, roomA, roomB);
    }
}
