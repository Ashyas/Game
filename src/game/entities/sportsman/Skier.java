package game.entities.sportsman;

import game.enums.Discipline;
import game.enums.Gender;


public class Skier extends WinterSportsman{
    public Skier(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline,String color) {
        super(name, age, gender, acceleration, maxSpeed, discipline,color);
    }
}
