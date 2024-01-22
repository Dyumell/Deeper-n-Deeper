import lombok.Data;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Data
public class RoomEvent extends AbstractRoomEvent{
    public static Map<String,RoomEvent> roomEventCodex = new HashMap<>(); // 모든 이벤트의 정보를 저장한 사전 역할을 하는 변수

    // 문제점 1. 프로그램 실행 최초에 사전이 생성되어 그 전에 생성되지 못한 playerNickName 을 참조하기 떄문에 null 이고
    // static 한 변수의 값은 이후에 바꿔도 반영되어 참조되지 않는다? static { 이벤트 정보 } 형태였음
    // 무엇보다 개념화 할 수 있는 대상만 static 하는 것이 바람직하다.

    public RoomEvent(){

    }

    public RoomEvent(String roomEventName){
        this.roomEventName =roomEventName;
    }

    public RoomEvent(String roomEventName,String roomEvenSummary,String roomEventDescription) {
        setRoomEventName(roomEventName);
        setRoomEventSummary(roomEvenSummary);
        setRoomEventDescription(roomEventDescription);
        // isEventDone 은 자동으로 false 로 생성된다.
    }
    public static void initializerRoomEvent(Character character){
        roomEventCodex.put("Vigor_Increase_Event",new RoomEvent("활력 상승 이벤트",
                "Vigor + 1",
                "신비한 빛이 " + character.getEntityName() + "을 감싼다, 활력이 1 상승한다"));
        roomEventCodex.put("Vigor_decrease_Event",new RoomEvent("활력 감소 이벤트",
                "Vigor - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 활력이 1 감소한다"));
        roomEventCodex.put("Endurance_Increase_Event", new RoomEvent("지구력 상승 이벤트",
                "Endurance + 1",
                "신비한 빛이" + character.getEntityName() + "을 감싼다, 지구력이 1 상승한다"));
        roomEventCodex.put("Endurance_Decrease_Event", new RoomEvent("지구력 상승 이벤트",
                "Endurance - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 지구력이 1 감소한다"));
        roomEventCodex.put("Mind_Increase_Event",new RoomEvent("정신력 상승 이벤트",
                "Mind + 1",
                "신비한 빛이 " + character.getEntityName() + "을 감싼다, 정신력이 1 상승한다"));
        roomEventCodex.put("Mind_Decrease_Event",new RoomEvent("정신력 감소 이벤트",
                "Mind - 1",
                "어두운 그림자가 "+ character.getEntityName() +"을 애워싼다, 정신력이 1 감소한다"));
        roomEventCodex.put("Strength_Increase_Event",new RoomEvent("근력 상승 이벤트",
                "Strength + 1",
                "신비한 빛이 " + character.getEntityName() + "을 감싼다, 근력이 1 상승한다"));
        roomEventCodex.put("Strength_Decrease_Event",new RoomEvent("근력 감소 이벤트",
                "Strength - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 근력이 1 감소한다"));
        roomEventCodex.put("Dexterity_Increase_Event",new RoomEvent("기교 상승 이벤트",
                "Dexterity + 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 기교가 1 상승한다"));
        roomEventCodex.put("Dexterity_Decrease_Event",new RoomEvent("기교 감소 이벤트",
                "Dexterity - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 기교가 1 감소한다"));
        roomEventCodex.put("Agility_Increase_Event",new RoomEvent("민첩 상승 이벤트",
                "Agility + 1",
                "신비한 빛이 " + character.getEntityName() + "을 감싼다, 민첩이 1 상승한다"));
        roomEventCodex.put("Agility_Decrease_Event",new RoomEvent("민첩 감소 이벤트",
                "Agility - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 민첩이 1 감소한다"));
        roomEventCodex.put("Magic_Increase_Event",new RoomEvent("마력 상승 이벤트",
                "Magic + 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 마력이 1 감소한다"));
        roomEventCodex.put("Magic_Decrease_Event",new RoomEvent("마력 감소 이벤트",
                "Magic - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 마력이 1 감소한다"));
        roomEventCodex.put("Faith_Increase_Event",new RoomEvent("신앙 상승 이벤트",
                "Faith + 1",
                "신비한 빛이 " + character.getEntityName() + "을 감싼다, 신앙이 1 상승한다"));
        roomEventCodex.put("Faith_Decrease_Event",new RoomEvent("신앙 감소 이벤트",
                "Faith - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 신앙이 1 감소한다"));
        roomEventCodex.put("Luck_Increase_Event",new RoomEvent("행운 상승 이벤트",
                "Luck + 1",
                "신비한 빛이 " + character.getEntityName() + "을 감싼다, 행운이 1 상승한다"));
        roomEventCodex.put("Luck_Decrease_Event",new RoomEvent("행운 감소 이벤트",
                "Luck - 1",
                "어두운 그림자가 " + character.getEntityName() + "을 애워싼다, 행운이 1 감소한다"));
        roomEventCodex.put("Normal_Battle_Event",new RoomEvent("일반 전투 이벤트",
                "Battle",
                "일반 전투 진입"));
        roomEventCodex.put("Boss_Battle_Event",new RoomEvent("보스 전투 이벤트",
                "Boss Battle",
                "보스 전투 진입"));
        roomEventCodex.put("Text_Printed_Event",new RoomEvent("텍스트 출력 이벤트","텍스트 출력 이벤트다",
                "Text"));
    }
    @Override
    public String toString() {
        return "RoomEvent{" +
                "roomEventName='" + getRoomEventName() + '\'' +
                ", roomEventSummary='" + getRoomEventSummary() + '\'' +
                ", roomEventDescription='" + getRoomEventDescription() + '\'' +
                ", isEventDone='" + getIsEventDone() + '\'' +
                '}';
    }
}
