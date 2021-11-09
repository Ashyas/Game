package game.entities.sportsman;

import game.entities.ICompetitorState;
import game.entities.MobileEntity;
import game.enums.Gender;
import game.enums.State;

import java.util.ArrayList;
import java.util.Random;

/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */


public class Sportsman extends MobileEntity implements ICompetitorState{
    private final String name;
    private final double age;
    private final Gender gender;
    private String color;
    private int competitorNumber;
    private static ArrayList<Integer> takenNumbers;
    private static int numbers =0;
    private State state;
    protected int outOfCompetition;

    public Sportsman(String name, double age, Gender gender, double acceleration, double maxSpeed,String color) {
        super(0, acceleration,maxSpeed);
        if(takenNumbers == null){
            takenNumbers = new ArrayList<Integer>();
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.competitorNumber = numbers;
        this.color = color;
        takenNumbers.add(competitorNumber);
        numbers++;
        state = State.Active;
        destiny();
    }

    //region Getters & setters
    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public int getCompetitorNumber() {return competitorNumber; }

    public boolean setCompetitorNumber(int competitorNumber) {
        if(!takenNumbers.contains(competitorNumber)){
            takenNumbers.remove((Integer)this.competitorNumber); //casting to obj
            this.competitorNumber = competitorNumber;
            takenNumbers.add(competitorNumber);
            return true;
        }
        return false;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void changeState(State newState) {
        this.state = newState;
        notifyObservers(state.name() + " " + getLocation().getX());
    }

    @Override
    public void destiny() {
        Random rnd = new Random();
        outOfCompetition = rnd.nextInt(1800); //twice the size of max arena
        //System.out.println(outOfCompetition);
    }

    @Override
    public State getState() {
        return this.state;
    }
}
