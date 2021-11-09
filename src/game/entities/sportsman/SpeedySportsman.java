package game.entities.sportsman;


/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */

public class SpeedySportsman extends WSDecorator {


    double bonus;
    public SpeedySportsman(IWinterSportsman winterSportsman, double bonus) {
        super(winterSportsman);
        this.bonus = bonus;
    }

    @Override
    public double getAcceleration() {
        return super.getAcceleration() + bonus ;
    }

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
}
