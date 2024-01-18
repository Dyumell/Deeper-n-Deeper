public class MovableCharacter extends Character implements IAscendable,IDescendable,IMovable{


    public MovableCharacter(String name, String species, String className) {
        super(name, species, className);
    }

    @Override
    public void ascend() { // 층을 올라가는 방에서 상호작용하여 캐릭터가 한층 올라가게 하는 메서드
        if ( getEntityFloor() == 1){ // 지하 1층의 경우, 올라가면 지상이다.
            System.out.println(getEntityName() + "씨는 던전에서 탈출하였습니다.");
            System.exit(0); // (질문).  자원누수 없이, 안전한 방법으로 프로그램을 종료하는 코드를 짜고싶습니다.
        } else {
            setEntityFloor(getEntityFloor() - 1);
            System.out.println(getEntityName() + "씨는 한 층 올라갔습니다. ( 현재 층 : 지하" + getEntityFloor()+"층 )");
        }
    }

    @Override
    public void descend(GameMap gameMap) {  // 층을 내려가는 방에서 상호작용하여 캐릭터가 한층 내려가게 하는 메서드
        if (getEntityFloor() >= gameMap.getLastFloor()) {// 던전의 마지막 층에서 내려가게 된다면, 엔딩이 등장한다. 하지만 추후에
            System.out.println(getEntityName()+ "씨는 힘을 찾아 더 깊은 곳으로 내려갔습니다. - 완 -");
        } else {                                         // 최하층에는 내려가는 이벤트를 두지 않게  수정할 것임
            setEntityFloor((getEntityFloor() + 1));
            System.out.println(getEntityName() + "씨는 한 층 내려갔습니다. ( 현재 층 : 지하" + getEntityFloor() + "층 )");
        }
    }

    @Override
    public void moveUpward() {
        System.out.println("아래쪽 방으로 들어갑니다");
    }

    @Override
    public void moveDownward() {
        System.out.println("위쪽 방으로 들어갑니다");
    }

    @Override
    public void moveLeft() {
        System.out.println("왼쪽 방으로 들어갑니다");
    }

    @Override
    public void moveRight() {
        System.out.println("오른쪽 방으로 들어갑니다");
    }
}
