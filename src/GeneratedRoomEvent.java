import lombok.Data;

import java.awt.*;

@Data
public class GeneratedRoomEvent extends RoomEvent{
    public GeneratedRoomEvent(){
        // (질문) @Data 를 사용하기 위해서 기본 생성자가 필요했습니다. 왜 필요한걸까요?
    }
    public GeneratedRoomEvent(int floor, Point eventRoomCoordinate, String roomEventName) {
        super(roomEventName);
        this.floor = floor;
        this.eventRoomCoordinate = eventRoomCoordinate;
    }

    int floor;
    Point eventRoomCoordinate;

    @Override
    public String toString() {
        return "GeneratedRoomEvent{" +
                "floor=" + floor +
                ", eventRoomCoordinate=" + eventRoomCoordinate +
                ", roomEventName='" + getRoomEventName() + '\'' +
                '}';
    }




}
