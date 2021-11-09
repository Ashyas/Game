package game.entities.sportsman;

import game.arena.IArena;
import game.competition.Competitor;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import game.enums.State;
import utilities.Point;

/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */


public class WinterSportsman extends Sportsman implements IWinterSportsman {
    private final Discipline discipline;
    private Point finish;

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getAge() {
        return super.getAge();
    }

    @Override
    public int getCompetitorNumber() {
        return super.getCompetitorNumber();
    }

    private IArena arena;

    public WinterSportsman(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline,String color) {
        super(name, age, gender, acceleration, maxSpeed,color);
        this.discipline = discipline;
    }
    public WinterSportsman(WinterSportsman ws){
        super(ws.getName(), ws.getAge(), ws.getGender(), ws.getAcceleration(), ws.getMaxSpeed(),ws.getColor());
        this.discipline = ws.discipline;
    }

    @Override
    public void initRace() {
        this.setLocation(new Point(0,this.getLocation().getY()));
    }
    
    @Override
    public void initRace(Point p, Point f, IArena arena) {
        this.setLocation(p); 
        this.finish = f;
        this.arena = arena;
    }

    @Override
    public Competitor makeCopy() {
        WinterSportsman instance = null;

        try {
            instance = (WinterSportsman) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return instance;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getName() + ". competitor number: " + getCompetitorNumber();
    }

    //region Getters & setters
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public double getAcceleration() {
        return super.getAcceleration()+ League.calcAccelerationBonus(this.getAge());
    }
    //endregion
    
	private boolean competitionInProgress() {
		boolean res = getLocation().getX() < finish.getX();
		Point p = getLocation();
		if (!res) setLocation(new Point(finish.getX(),p.getY()));
		return res;
	}

	private boolean injuredOrDisabled(){ //you an change to void
        if(getLocation().getX() >= outOfCompetition)
        {
            if(outOfCompetition%2 ==0) //injured
                changeState(State.Injured);
            else
                changeState(State.Disabled);
            return true;
        }
        return false;
    }
    
	
	@Override
	public void run() {
		while (competitionInProgress() && !injuredOrDisabled()) {
			move(arena.getFriction());
            try {
                   Thread.sleep(100);
            } catch (InterruptedException ex) {
                   ex.printStackTrace();
            }
		}

		setChanged();
		notifyObservers("Finished");
		//setChanged();
		//notifyObservers(); // old use
	}




}
