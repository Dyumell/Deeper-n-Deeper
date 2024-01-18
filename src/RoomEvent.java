import lombok.Data;

import java.awt.*;

@Data
public class RoomEvent extends AbstractRoomEvent{
    public RoomEvent(int floor,Point eventRoomCoordinate,String roomEventName){
        this.floor = floor;
        this.eventRoomCoordinate = eventRoomCoordinate;
        this.roomEventName =roomEventName;
    }

    int floor;
    Point eventRoomCoordinate;
    String roomEventName;

    @Override
    public String toString() {
        return "RoomEvent{" +
                "floor=" + floor +
                "층 , eventRoomCoordinate=" + eventRoomCoordinate +
                ", roomEventName='" + roomEventName + '\'' +
                '}';
    }
}
