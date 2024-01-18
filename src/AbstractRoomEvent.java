import lombok.Data;

import java.util.AbstractMap;
import java.util.Map;
@Data
public abstract class AbstractRoomEvent {

    String roomEventName;

    private static Map<String,RoomEvent> roomEventCodex; // 룸 이벤트들의 정보를 가진 사전 변수.

}
