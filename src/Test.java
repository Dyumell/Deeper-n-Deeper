public class Test { // 이것은 맵 생성과 캐릭터 생성을 위한 메인 메서드를 가지고있는 테스트 클래스입니다.
    public static void main(String[] args) {
        GameMap gm = new GameMap(2,4,4); // 맵크기를 2층, 4행 , 4열로 총 16개의 방 x 2 = 32 방 생성

        Character player = new MovableCharacter("박철흠","인간","도적");
        // 박철흠씨는 불우한 유년기를 보낸 끝에 , 일확천금을 노리는 도적이 되어 이 던전에 들어왔습니다.

        gm.generateDescendingRoom(); // 던전의 내려가는방 지정하는 메서드
        gm.generateAscendingRoom(gm.getEventRooms()); // 던전의 올라가는 방( 캐릭터 생성 지점 ) 지정하는 메서드
        gm.generateEventRoom(gm.getEventRooms()); // 던전에 이벤트를 포함한 방 지정하는 메서드

        gm.viewGameMap(); // 생성된 맵의 좌표들과, 좌표들에 할당된 이벤트를 확인하는 메서드

        player.loadCharacterToGameMapCoordinate(gm); // 캐릭터가 생성지점 위치를 가르키는 좌표를 가지고 생성
        System.out.println(player.toString()); // 캐릭터가 잘 생성됬는지 확힌하기위해 오버라이드된 toString()을 출력
        System.out.println(player.getEntityName() + "씨는 불우한 유년기를 보낸 끝에, 일확천금을 노리는 도적이 되어" +
                " 이 던전에 들어왔습니다. \n그의 앞에 놓인 운명은 찬란한 황금일까, 비참한 말로일까.\n오직 행운의 여신만을 믿는 철흠씨는" +
                " 이번 약탈이 평소와도 다를 바 없이, 안전하게 마무리되기를 빌며 가벼운 주머니에 몇 개 남지 않은 동화 한닢을 삼키며 " +
                " 볼품없이 어색한 기도를 올립니다");

        ((MovableCharacter) player).descend(gm);
        ((MovableCharacter) player).descend(gm);
        ((MovableCharacter) player).ascend(); // (질문). Cast Qualifier 를 왜 써야하나요? 이 구조가 잘 이해가 가지 않습니다.
        ((MovableCharacter) player).ascend();


        // 다음 구현 과제는, [1]IMovable 인터페이스 구현과, [2]이벤트 사전 만들기와, [3]npc들의 배치와, [4]캐릭터의 이동을 순차적으로 구현




    }
}
