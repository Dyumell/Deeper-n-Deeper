import java.awt.*;

public class StatUpEvent extends RoomEvent {
    int increment;
    String statName;

    public StatUpEvent(int floor,Point eventRoomCoordinate, String roomEventName, String statName, int increment) {
        super(floor,eventRoomCoordinate,roomEventName);
        this.statName = statName;
        this.increment = increment;
    }
}
