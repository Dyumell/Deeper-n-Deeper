public class CharacterStatChanger {
    public static void increaseCharacterStat(Character character, String statName, int increment) {
        switch (statName) {
            case "HealthPoint":
                character.setHealthPoint(character.getHealthPoint() + increment);
                break;
            case "ManaPoint":
                character.setManaPoint(character.getManaPoint() + increment);
                break;
            case "EndurancePoint":
                character.setEndurancePoint(character.getExperiencePoint()+increment);
                break;
            case "Vigor":
                character.setVigor(character.getVigor() + increment);
                break;
            case "Mind":
                character.setMind(character.getMind() + increment);
                break;
            case "Endurance":
                character.setEndurance(character.getEndurance() + increment);
                break;
            case "Strength":
                character.setStrength(character.getStrength() + increment);
                break;
            case "Dexterity":
                character.setDexterity(character.getDexterity() + increment);
                break;
            case "Agility":
                character.setAgility(character.getAgility() + increment);
                break;
            case "Magic":
                character.setMagic(character.getMagic() + increment);
                break;
            case "Faith":
                character.setFaith(character.getFaith() + increment);
                break;
            case "Luck":
                character.setLuck(character.getLuck() + increment);
                break;
            case "ExperiencePoint":
                character.setExperiencePoint(character.getExperiencePoint() + increment);
                break;
            case "Level":
                character.setLevel(character.getLevel() + increment);
                break;
        }
    }

    public static void decreaseCharacterStat(Character character, String statName, int decrement) {
        switch (statName) {
            case "HealthPoint":
                character.setHealthPoint(character.getHealthPoint() - decrement);
                break;
            case "ManaPoint":
                character.setManaPoint(character.getManaPoint() - decrement);
                break;
            case "EndurancePoint":
                character.setEndurancePoint(character.getExperiencePoint() - decrement);
                break;
            case "Vigor":
                character.setVigor(character.getVigor() - decrement);
                break;
            case "Mind":
                character.setMind(character.getMind() - decrement);
                break;
            case "Endurance":
                character.setEndurance(character.getEndurance() - decrement);
                break;
            case "Strength":
                character.setStrength(character.getStrength() - decrement);
                break;
            case "Dexterity":
                character.setDexterity(character.getDexterity() - decrement);
                break;
            case "Agility":
                character.setAgility(character.getAgility() - decrement);
                break;
            case "Magic":
                character.setMagic(character.getMagic() - decrement);
                break;
            case "Faith":
                character.setFaith(character.getFaith() - decrement);
                break;
            case "Luck":
                character.setLuck(character.getLuck() - decrement);
                break;
            case "ExperiencePoint":
                character.setExperiencePoint(character.getExperiencePoint() - decrement);
                break;
            case "Level":
                character.setLevel(character.getLevel() - decrement);
                break;
        }
    }

    public static void initializeCharacterStat(Character character, String statName, int initializingValue) {
        switch (statName) {
            case "HealthPoint":
                character.setHealthPoint(initializingValue);
                break;
            case "ManaPoint":
                character.setManaPoint(initializingValue);
                break;
            case "EndurancePoint":
                character.setEndurancePoint(initializingValue);
                break;
            case "Vigor":
                character.setVigor(initializingValue);
                break;
            case "Mind":
                character.setMind(initializingValue);
                break;
            case "Endurance":
                character.setEndurance(initializingValue);
                break;
            case "Strength":
                character.setStrength(initializingValue);
                break;
            case "Dexterity":
                character.setDexterity(initializingValue);
                break;
            case "Agility":
                character.setAgility(initializingValue);
                break;
            case "Magic":
                character.setMagic(initializingValue);
                break;
            case "Faith":
                character.setFaith(initializingValue);
                break;
            case "Luck":
                character.setLuck(initializingValue);
                break;
            case "ExperiencePoint":
                character.setExperiencePoint(initializingValue);
                break;
            case "Level":
                character.setLevel(initializingValue);
                break;

        }
    }
}