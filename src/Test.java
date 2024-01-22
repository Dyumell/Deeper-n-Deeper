import jdk.jfr.Event;

public class Test { // 이것은 맵 생성과 캐릭터 생성을 위한 메인 메서드를 가지고있는 테스트 클래스입니다.
    public static void main(String[] args) {
        GameMap gm = new GameMap(1,2, 4, 4); // 맵크기를 2층, 4행 , 4열로 총 16개의 방 x 2 = 32 방 생성

        Character player = new MovableCharacter("박철흠", "인간", "도적");
        // 박철흠씨는 불우한 유년기를 보낸 끝에 , 일확천금을 노리는 도적이 되어 이 던전에 들어왔습니다.


        gm.generateDescendingRoom(1); // 던전의 내려가는방 지정하는 메서드
        gm.generateAscendingRoom(gm.getEventRooms()); // 던전의 올라가는 방( 캐릭터 생성 지점 ) 지정하는 메서드
        gm.generateEventRoom(gm.getEventRooms()); // 던전에 이벤트를 포함한 방 지정하는 메서드

        gm.viewGameMap(); // 생성된 맵의 좌표들과, 좌표들에 할당된 이벤트를 확인하는 메서드

        player.loadCharacterToGameMapCoordinate(gm); // 캐릭터가 생성지점 위치를 가르키는 좌표를 가지고 생성
        System.out.println(player.toString()); // 캐릭터가 잘 생성됬는지 확힌하기위해 오버라이드된 toString()을 출력
        System.out.println(player.getEntityName() + "씨는 불우한 유년기를 보낸 끝에, 일확천금을 노리는 도적이 되어" +
                " 이 던전에 들어왔습니다. \n그의 앞에 놓인 운명은 찬란한 황금일까, 비참한 말로일까.\n오직 행운의 여신만을 믿는 철흠씨는" +
                " 이번 약탈이 평소와도 다를 바 없이, 안전하게 마무리되기를 빌며 가벼운 주머니에 몇 개 남지 않은 동화 한닢을 삼키며 " +
                " 볼품없이 어색한 기도를 올립니다");


        ((MovableCharacter) player).moveRight(gm);
        ((MovableCharacter) player).moveRight(gm);
        ((MovableCharacter) player).moveRight(gm);
        ((MovableCharacter) player).moveRight(gm);
        ((MovableCharacter) player).moveRight(gm);
        ((MovableCharacter) player).moveLeft();
        ((MovableCharacter) player).moveUpward(gm);
        ((MovableCharacter) player).moveUpward(gm);
        ((MovableCharacter) player).moveUpward(gm);
        ((MovableCharacter) player).moveUpward(gm);
        ((MovableCharacter) player).moveDownward();


        ((MovableCharacter) player).descend(gm);
        ((MovableCharacter) player).descend(gm);
        ((MovableCharacter) player).ascend(); // (질문). Cast Qualifier 를 왜 써야하나요? 이 구조가 잘 이해가 가지 않습니다.
        // ((MovableCharacter) player).ascend();

        //Character anotherPlayer = new Character("복재성", "인간", "사제"); 복제성으로 실험을 하기 위함

        RoomEvent.initializerRoomEvent(player);

        //System.out.println(RoomEvent.roomEventCodex.get("Faith_Increase_Event").toString()); // 캐릭터와 이벤트가 연결되는지 확인하기 위함

        // System.out.println(EventRandomizer.RandomizeEvent()); 이벤트가 확률적으로 잘 출력되는지 확인하기 위함

        player.experienceEvent(player, gm.getEventRooms()); // (질문) 제네릭으로 상위 클래스를 할당했는데, 하위클래스를 매개변수로 받을 수 없었다.
//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "RoomEvent.getRoomEventDescription()" because the return value of "java.util.Map.get(Object)" is null
//	at Character.executeStatIncreaseRoomEvent(Character.java:196)
//	at Character.experienceEvent(Character.java:144)
//	at Test.main(Test.java:51) 오류 발생.
        //해결함 -> 처음부터 오류코드를 잘 읽었다면 금방 해결했을 문제였음. 이벤트 사전에 Endurance를 추가 하지 않아서 null이 불러와짐.

        // RoomEvent 사전의 데이터 와 getEventRooms() 를 연결



        // 구현 완료 과제 :[1] IMovable 구체화 , [2]. 이벤트 사전 만들기 및 이벤트 구현 ( 텍스트출력 이벤트, 전투 이벤트 제외)
        // 다음 구현 과제 :[3]npc 들의 배치와, [4]캐릭터의 이동을 순차적으로 구현

        // 이벤트 처리 여부에 대한 부울린은 빼버리고, 이벤트의 작동 순서를 정해놓으면 좋을 것 같다.


        // * 심각한 버그 발생, 가끔 가다가 좌표가 9,2가 된다.

        //System.out.println(player.toString());

        // 이벤트의 순서를 정한다음, 마지막 이벤트가 끝나면 해당 방에 대한 이벤트를 getEventRooms() 에서 지우도록하자.
        // 텍스트 출력 이벤트 -> 텍스트 출력 이벤트 삭제 -> 전투 이벤트 -> 전투 이벤트 삭제 -> 능력치 상승/하강 이벤트 ->
        // 능력치 상승 / 하상 이벤트 삭제 -> currentRoomEvents 리스트 안에 요소가 없을 시,
        // GeneratedRoomEvent의 해당좌표의 이벤트 완전 삭제


    }

}

