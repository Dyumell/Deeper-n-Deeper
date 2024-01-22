import java.awt.*;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// 정말 막막해서, 주석부터 단 다음, 메서드 부터 정의했는데, 아주 도움이 된 것 같다.

public class BattleSystem {
    // 난수를 돌려서 그 수에 해당하는 몬스터 생성자 생성  후 전투
    // 생성된 몬스터 정보는 저장됨 ( 도망 후 다시 싸우울 수 있기 때문 )
    Random randomIntegerGenerator = new Random();
    int randomInt = randomIntegerGenerator.nextInt(100)+1;

    // 해당 좌표에 저장된 몬스터가 있는지 검사하고 없으면
    // 확률에 기반한 몬스터 생성
    // 있으면 저장된 몬스터를 반환하는 함수
    public Character generateRandomEnemy(Point enemyGeneratingFloor){
        return null;
    }
    public Character loadStoredEnemy(Point enemyStoredCoordinate){
        return null;
    }

    // 전투에서 도망칠 시, 해당 몬스터의 정보와 좌표를 저장하는 메서드와 변수
    int enemyStoredFloor;
    Point enemyStoredCoordinate;
    public void StoreEnemyCoordinate(Character enemy){

    }


    public void battle(Character player, Character enemy){
        while(true){

        }
    }




}
