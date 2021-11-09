package game.entities.sportsman;

import game.arena.IArena;
import game.competition.Competitor;
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

abstract class WSDecorator implements IWinterSportsman {

    protected IWinterSportsman winterSportMan;

    @Override
    public String getName() {
        return winterSportMan.getName();
    }

    @Override
    public double getAge() {
        return winterSportMan.getAge();
    }

    @Override
    public int getCompetitorNumber() {
        return winterSportMan.getCompetitorNumber();
    }

    public WSDecorator(IWinterSportsman winterSportsman){
        this.winterSportMan = winterSportsman;
    }

    @Override
    public String getColor() {
        return winterSportMan.getColor();
    }

    @Override
    public double getAcceleration() {
        return winterSportMan.getAcceleration();
    }

    @Override
    public void initRace() {
        winterSportMan.initRace();
    }

    @Override
    public void initRace(Point p, Point f, IArena arena) {
        winterSportMan.initRace(p,f,arena);
    }



    @Override
    public Competitor makeCopy() {
        return winterSportMan.makeCopy();
    }

    @Override
    public void run() {
        winterSportMan.run();
    }

    @Override
    public void move(double friction) {
        winterSportMan.move(friction);
    }

    @Override
    public Point getLocation() {
        return winterSportMan.getLocation();
    }

    @Override
    public double getSpeed() {
        return winterSportMan.getSpeed();
    }

    @Override
    public double getMaxSpeed() {
        return winterSportMan.getMaxSpeed();
    }

    @Override
    public boolean setCompetitorNumber(int num) {
        return winterSportMan.setCompetitorNumber(num);
    }


}
