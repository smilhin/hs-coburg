import java.util.Arrays;
import java.util.List;

public class VacuumState implements State {
    private String position; // "RoomA", "RoomB"
    private boolean roomADirty;
    private boolean roomBDirty;

    public VacuumState(String position, boolean leftDirty, boolean rightDirty) {
        this.position = position;
        this.roomADirty = leftDirty;
        this.roomBDirty = rightDirty;
    }

    public String getPosition() {
        return position;
    }

    public boolean isRoomADirty() {
        return roomADirty;
    }

    public boolean isRoomBDirty() {
        return roomBDirty;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VacuumState)) return false;
        VacuumState other = (VacuumState) o;
        return this.position.equals(other.position) &&
                this.roomADirty == other.roomADirty &&
                this.roomBDirty == other.roomBDirty;
    }

    @Override
    public String toString() {
        return "Position: " + position + ", Left dirty: " + roomADirty + ", Right dirty: " + roomBDirty;
    }
}
