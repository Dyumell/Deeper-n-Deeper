import lombok.Data;

import java.util.AbstractMap;
import java.util.Map;
@Data
public abstract class AbstractRoomEvent {

    String roomEventName;
    String roomEventSummary;
    String roomEventDescription;
    Boolean isEventDone; // 이벤트가 끝나면 true 가 되어, 메서드를 호출 할 때 true 인 이벤트들을 삭제하기 위해 추가한 변수

    private static Map<String,RoomEvent> roomEventCodex; // 룸 이벤트들의 정보를 가진 사전 변수.

}
