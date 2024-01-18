import lombok.Data;

import java.awt.*;

@Data
public abstract class AbstractEntity {
    // 추후 개발의 확장성을 위해 상호작용이 가능한 모든 무생물, 생물을 개념적으로 의미하는 추상 클래스를 최상위 클래스로 상속

    String entityName;    // 모든 개체는 이름이 있다.
    String species;     // 모든 개체는 종이 있다.
    Point entityRoomCoordinate;            // 모든 개체는 게임 안의 특정 좌표에 존재한다.
    int entityFloor;      // 모든 개체는 게임 안의 특정 층에 존재한다


}
