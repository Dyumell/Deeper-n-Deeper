import java.awt.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class GameMap extends AbstractGameMap {
    public GameMap(int maxFloor, int roomRow, int roomColumn) {
        setLastFloor(maxFloor);
        setCurrentFloor(getLastFloor());
        setMapCoordinateArray(new int[roomRow][roomColumn]); // 맵 전체에 대한 좌표를 생성
        setGameMapRowIndex(roomRow); // 이벤트를 향상된 for 문으로 할당할 때, 행의 최대값이 넘어가면 행 index 값을 0으로
        // 초기화 하기위한 게임맵 최대 행의 인덱스 변수
        // -> 텅 빈 맵을 생성
    }

    @Override
    public void generateDescendingRoom() {
        int generatedGameMapRowIndex = 0; // 이벤트를 할당하기 위해 생성한 게임맵을 나타내는 행렬의 인덱스를 저장하는 변수들
        int generatedGameMapColumnIndex = 0;

        setRandomIntegerGenerator(new Random()); // 랜덤 객체 생성 , 한번만 생성해서 앞으로 계속 쓴다.
        setEventRooms(new LinkedList<>()); // 수정해야할 것이, 이러면 층을 구분을 못함.

        while (true) { // 내려가는 방이 정해질 떄 까지 반복문을 돌림
            for (int[] arrayRowAndColumn : getMapCoordinateArray()) { // 2차원 배열에 대한 향상된 for 문 사용
                generatedGameMapColumnIndex = 0;
                for (int arrayRow : arrayRowAndColumn) {

                    setRandomlyGeneratedInteger(getRandomIntegerGenerator().nextInt(100) + 1); // 난수를 얻음 ( 1 ~ 100 )

                    if (getRandomlyGeneratedInteger() <= 5) {    // 각 좌표마다 난수를 구해서, 5%확률로 내려가는 방으로 지정
                        getEventRooms().add(new RoomEvent
                                (getCurrentFloor(), new Point(generatedGameMapRowIndex, generatedGameMapColumnIndex),
                                        " 내려가는 이벤트 "));
                        setDescendingFloorCoordinate(new Point(generatedGameMapRowIndex,generatedGameMapColumnIndex));
                        return;    // 내려가는 방은 층마다 오직 하나로, 방이 정해지면 반복문을 탈출
                    }
                    if (generatedGameMapRowIndex > getGameMapRowIndex()) {
                        generatedGameMapRowIndex = 0;   // 게임 맵의 행렬중 행의 값이  생성자에서 입력한 행 값보다 커질시, 0으로 초기화
                    } else {
                        generatedGameMapColumnIndex++; // 다음 행으로 이동
                    }
                }
                generatedGameMapRowIndex++;
            }
        }
    }


    @Override
    public void generateAscendingRoom(List<RoomEvent> eventRooms) { //  첫번째 층의 올라가는 방은 플레이어의 생성 / 출발 지점이다.
        int generatedGameMapRowIndex = 0; // 이벤트를 할당하기 위해 생성한 게임맵을 나타내는 행렬의 인덱스를 저장하는 변수들
        int generatedGameMapColumnIndex = 0;

        while (true) { // 올라가는 방이 정해질 떄 까지 반복문을 돌림
            for (int[] arrayRowAndColumn : getMapCoordinateArray()) { // 2차원 배열에 대한 향상된 for 문 사용
                generatedGameMapColumnIndex = 0;
                for (int arrayRow : arrayRowAndColumn) {

                    setRandomlyGeneratedInteger(getRandomIntegerGenerator().nextInt(100) + 1); // 난수를 얻음 ( 1 ~ 100 )

                    if (getRandomlyGeneratedInteger() <= 5) {    // 각 좌표마다   난수를 구해서, 5%확률로 내려가는 방으로 지정
                        setAscendingFloorCoordinate(new Point(generatedGameMapRowIndex,generatedGameMapColumnIndex));
                        if (!getDescendingFloorCoordinate().equals(getAscendingFloorCoordinate())); // 강사님 이거 되나요?
                        getEventRooms().add(new RoomEvent
                                (getCurrentFloor(), new Point(generatedGameMapRowIndex, generatedGameMapColumnIndex),
                                        "올라가는 이벤트"));
                        return;    // 내려가는 방은 층마다 오직 하나로, 방이 정해지면 반복문을 탈출
                    }
                    if (generatedGameMapRowIndex > getGameMapRowIndex()) {
                        generatedGameMapRowIndex = 0;   // 게임 맵의 행렬중 행의 값이  생성자에서 입력한 행 값보다 커질시, 0으로 초기화
                    } else {
                        generatedGameMapColumnIndex++; // 다음 행으로 이동
                    }
                }
                generatedGameMapRowIndex++;
            }
        }


    }

    @Override
    public void generateEventRoom(List<RoomEvent> eventRooms) {       // 이벤트를 좌표에 할당
        int generatedGameMapRowIndex = 0;       // 이벤트를 할당하기 위해 생성한 게임맵을 나타내는 행렬의 인덱스를 저장하는 변수들
        int generatedGameMapColumnIndex = 0;


        setNotEventGeneratedFloor(getCurrentFloor() - 1); //  한 층의 이벤트들을 생성 후, 전체 층수에서 한층을 뺀다

        // 그냥 for 문이 더 효율적일 것 같다.

        for (int[] arrayRowAndColumn : getMapCoordinateArray()) {
            generatedGameMapColumnIndex = 0;    //  2차원 배열의 행렬에서 열에 해당하는 인덱스를 0으로 초기화 하여 사용 준비

            for (int arrayRow : arrayRowAndColumn) {
                setRandomlyGeneratedInteger(getRandomIntegerGenerator().nextInt(100) + 1); // 1 ~ 100

                //region 일반 전투 이벤트 생성 조건
                if (getRandomlyGeneratedInteger() >= 40) {   // 난수 돌려서 나온 값이 60이 넘을시 동작 (이벤트가 방에 할당될 확률 60%)
                    // 이벤트 할당
                    getEventRooms().add(new RoomEvent
                            (getCurrentFloor(), new Point(generatedGameMapRowIndex, generatedGameMapColumnIndex),
                                    " 일반 전투 이벤트"));
                    // 일반 전투 이벤트를 조건을 통과한 좌표에 할당
                }
                //endregion

                setRandomlyGeneratedInteger(getRandomIntegerGenerator().nextInt(100) + 1);

                //region 텍스트 출력 이벤트 생성 조건
                if (getRandomlyGeneratedInteger() >= 60) { // 이벤트 2개가 방에 할당될 확률 (60% x 40%)
                    // 이벤트 할당
                    getEventRooms().add(new RoomEvent
                            (getCurrentFloor(), new Point(generatedGameMapRowIndex, generatedGameMapColumnIndex),
                                    " 텍스트 출력 이벤트"));
                    // 텍스트 출력 이벤트를 조건을 통과한 좌표에 할당
                }
                //endregion

                setRandomlyGeneratedInteger(getRandomIntegerGenerator().nextInt(100) + 1);

                //region 스텟 상승 / 하락 이벤트 생성 조건
                if (getRandomlyGeneratedInteger() >= 70) {  // 이벤트 3개가 방에 할당될 확률 (60% x 40% x 20% )
                    setRandomlyGeneratedInteger(getRandomIntegerGenerator().nextInt(100) + 1);
                    // 이벤트 할당
                    getEventRooms().add(new RoomEvent
                            (getCurrentFloor(), new Point(generatedGameMapRowIndex, generatedGameMapColumnIndex),
                                    " 스텟 상승 이벤트"));
                    // 스텟 상승 이벤트를 조건을 통과한 좌표에 할당
                } else { // 스텟 상승 이벤트 조건을 좌표가 할당 받지 못한 경우, 스텟 하강 이벤트 할당 조건을 거치게된다.
                    setRandomlyGeneratedInteger(getRandomIntegerGenerator().nextInt(100) + 1);
                    if (getRandomlyGeneratedInteger() >= 85) { // 이벤트 3개가 방에 할당될 또 다른 확률 (60% x 40% x 20% x 15% )
                        // 이벤트 할당
                        getEventRooms().add(new RoomEvent
                                (getCurrentFloor(), new Point(generatedGameMapRowIndex, generatedGameMapColumnIndex),
                                        " 스텟 하락 이벤트"));
                        // 스텟 하락 이벤트 조건을 통과한 좌표에 할당
                    }
                } // 스텟 하락 이벤트
                //endregion

                generatedGameMapColumnIndex++;
            }
            generatedGameMapRowIndex++;
        }
    }

    public void viewGameMap() {
        for (int i = 0; i < getEventRooms().size(); i++) {
            System.out.println(getEventRooms().get(i).toString());
        }

    }


}
