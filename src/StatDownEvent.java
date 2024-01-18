import java.awt.*;

public class StatDownEvent extends RoomEvent{
    int decrement;
    String statName;

    public StatDownEvent(int floor,Point eventRoomCoordinate, String roomEventName, String statName, int decrement) {
        super(floor,eventRoomCoordinate,roomEventName);
        this.statName = statName;
        this.decrement = decrement;
    }
}
