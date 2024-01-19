import java.util.Random;

public class EventRandomizer {
    private static Random randomizer;
    private static int randomizedInteger;

    public static String RandomizeEvent() {
        Random randomIntegerGenerator = new Random();
        randomizedInteger = randomIntegerGenerator.nextInt(100) + 1; // 범위 : 1 ~ 100 의 난수 생성

        if (randomizedInteger <= 15) {
            return "Vigor";
        }
        if (randomizedInteger >= 16 && randomizedInteger <= 30) {
            return "Mind";
        }
        if (randomizedInteger >= 31 && randomizedInteger <= 45) {
            return "Endurance";
        }
        if (randomizedInteger >= 46 && randomizedInteger <= 55) {
            return "Strength";
        }
        if (randomizedInteger >= 56 && randomizedInteger <= 65) {
            return "Dexterity";
        }
        if (randomizedInteger >= 66 && randomizedInteger <= 75) {
            return "Agility";
        }
        if (randomizedInteger >= 76 && randomizedInteger <= 85) {
            return "Magic";
        }
        if (randomizedInteger >= 86 && randomizedInteger <= 95) {
            return "Faith";
        }
        if (randomizedInteger >= 96 && randomizedInteger <= 100) {
            return "Luck";
        }

        return "Unknown";
    }
}
