import lombok.Data;

import java.awt.*;

@Data
public class Character extends AbstractEntity {
    // 추후 개발의 확장성을 위해 상호작용이 가능한 모든 무생물, 생물을 개념적으로 의미하는 추상 클래스를 최상위 클래스로 상속

    String className = "";          // 직업에 해당하는 클래스는 있을 수도 있고, 없을 수도 있다.
    //region ----------- 기본 능력치(Stat)  -----------
    private int healthPoint;        // 모든 캐릭터는 생명력이 있고 0이되면 죽은 상태이다.
    private int manaPoint;          // 모든 캐릭터는 스스로 인지하든 못하든 마나 포인트가 존재한다.
    private int endurancePoint;     // 모든 캐릭터는 행위를 하는 동력이 되는 지구력 포인트가 존재한다.
    private int vigor;              // 활력은 생명력 총량의 증가에 관여한다
    private int mind;               // 정신력은 마나 포인트 증가에 관여한다
    private int endurance;          // 지구력의 총량 증가에 관여한다.
    //endregion -------- 기본 능력치  -----------

    //region ----------- 레벨 능력치(Stat)  -----------
    private int experiencePoint;        // 모든 캐릭터는 레벨 능력치를 가지고 있다. ( experiencePoint > 0  && level > 0 )
    private int level;
    //endregion -------- 레벨 능력치  -----------

    //region ----------- 기술 능력치(Stat)  -----------
    private int strength;               // 모든 캐릭터는 기술 능력치를 가지고 있다. ( 모든 기술 능력치 > 0 )
    private int dexterity;
    private int agility;
    private int magic;
    private int faith;
    private int luck;
    //endregion -------- 기술 능력치  -----------

    public Character(String name,String species, String className){
        // 캐릭터가 생성될 때 가지는 능력치들

        // 캐릭터 기본 정보
        this.entityName = name;
        this.species = species;
        this.className = className;
        // 캐릭터 기초 능력치
        this.vigor = 5;
        this.mind = 5;
        this.endurance = 5;
        this.healthPoint += (20 * this.vigor);
        this.manaPoint += (15 * this.mind);
        this.endurancePoint += (20 * this.endurance);
        // 캐릭터 스킬 능력치
        this.strength = 5;
        this.dexterity = 5;
        this.agility = 5;
        this.magic = 5;
        this.faith = 5;
        this.luck = 5;
        // 캐릭터 레벨 능력치
        this.level = 1;
        this.experiencePoint = 1;
    }

    //region 기본 능력치 설정 메서드
    public void adjustHealthPoint(){
        this.healthPoint += (20 * this.vigor);
    };
    public void adjustManaPoint(){
        this.manaPoint += (15 * this.mind);
    }
    public void adjustEndurancePoint(){
        this.endurancePoint += (20 * this.endurance);
    }

    //endregion

    void loadCharacterToGameMapCoordinate(GameMap gameMap) {
        // 캐릭터는 층을 내려가면서 이동한다. 즉 아랫층의 올라가는 방은 캐럭터가 내려온 방이 된다.
        // 그럼으로 올라가는 방의 좌표에 캐릭터가 위치하게 된다.
        setEntityRoomCoordinate(gameMap.getAscendingFloorCoordinate());

        setEntityFloor(1); // 1은 지하 1을 의미한다고 약속합니다.
        // 캐릭터의 현재 층 위치에 해당하는 변수에 가장 최상위 층 ( 지하 1층 )을 할당
        // 이 게임은 아래로 내려가는 게임이기 떄문임
    }



    @Override
    public String toString() {
        return "Character{" +
                "className='" + className + '\'' +
                ", entityName='" + entityName + '\'' +
                ", species='" + species + '\'' +
                ", healthPoint=" + healthPoint +
                ", manaPoint=" + manaPoint +
                ", endurancePoint=" + endurancePoint +
                ", vigor=" + vigor +
                ", mind=" + mind +
                "\n, experiencePoint=" + experiencePoint +
                ", level=" + level +
                "\n, strength=" + strength +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", magic=" + magic +
                ", faith=" + faith +
                ", luck=" + luck +
                "\n, entityRoomCoordinate=" + entityRoomCoordinate +
                ", entityFloor=" + entityFloor +
                '}';
    }
}
