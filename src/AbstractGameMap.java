import lombok.Data;

import java.awt.*;
import java.util.*;
import java.util.List;

@Data
public abstract class AbstractGameMap {
// 확장과 수정을 위해서 추상 맵 클래스부터 생성했음.

    // 한번 생성된 이벤트 정보를 저장해 놓는
    // 층수에 따라 요소 개수가 바뀌는
    // 리스트가 필요하다.
    // 내려갔다가 올라오면, 다시 이벤트 할당을 하지 않을 것이기 때문이다.

    private int[][] mapCoordinateArray;      // 텍스트 기반 게임이기 때문에, 시각적인 맵 없이, 좌표를 하나의 방이라고 여긴다.
    // [][] : 방의 행렬
    private int currentFloor;  // 층에 대한 정보를 가지고있음.
    private int lastFloor;
    private Point descendingFloorCoordinate;    // 다음 층으로 내려가는 방에 대한 좌표 , 보스 전투 이벤트가 이 좌표에 존재한다.
    private Point ascendingFloorCoordinate;     // 이전 층으로 올라가는 방에 대한 좌표 , 첫번째 층의 올라가는 방은 플레이어의 생성 / 출발 지점이다.

    private int notEventGeneratedFloor; // 한 층 내려갈 때 마다 이벤트를 할당하기 위해, 내려가지 않은 층 정보를 저장하는 변수

    private int gameMapRow;
    private int gameMapColumn;
    private int gameMapRowIndex = 0;
    private int gameMapColumnIndex = 0;

    private Random randomIntegerGenerator;     // Event 가 존재하는 방을 무작위로 생성하기 위한 난수 값
    private int randomlyGeneratedInteger;       // Event 가 존재하는 방을 무작위로 생성하기 위한 난수 값
                                               // 추가로 나중에 장애물을 생성하기 위한 변수/ 메서드도 구현하고싶음


    private List<GeneratedRoomEvent> EventRooms;       // 방 좌표에 이벤트들을 저장할 사전 변수 ( 한방에 최대 3개 )


    public void generateDescendingRoom(){

    }

    public void generateAscendingRoom(List<GeneratedRoomEvent> eventRooms){

    }

    public void generateEventRoom(List<GeneratedRoomEvent> eventRooms){

    }

    @Override
    public String toString() {
        return "AbstractGameMap{" +
                "mapCoordinateArray=" + Arrays.toString(mapCoordinateArray) +
                ", lastfloor=" + lastFloor +
                ", currentfloor=" + currentFloor +
                ", descendingFloorCoordinate=" + descendingFloorCoordinate +
                ", notEventGeneratedFloor=" + notEventGeneratedFloor +
                ", gameMapRow=" + gameMapRow +
                ", gameMapColumn=" + gameMapColumn +
                ", gameMapRowIndex=" + gameMapRowIndex +
                ", gameMapColumnIndex=" + gameMapColumnIndex +
                ", randomIntegerGenerator=" + randomIntegerGenerator +
                ", randomlyGeneratedInteger=" + randomlyGeneratedInteger +
                ", EventRooms=" + EventRooms +
                '}';
    }
}
