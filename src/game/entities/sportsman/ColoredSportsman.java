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

public class ColoredSportsman extends WSDecorator {

    String ExtraColor;
    public ColoredSportsman(IWinterSportsman winterSportsman,String color) {
        super(winterSportsman);
        ExtraColor = color;
    }

    @Override
    public String getColor() {
        return ExtraColor;
    }

    //need to call function updateCompetitorImage()

}
