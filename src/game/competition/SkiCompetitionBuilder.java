package game.competition;

import game.arena.ArenaFactory;
import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.enums.*;

/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */

public class SkiCompetitionBuilder {

    public SkiCompetition skiComp;
    public ArenaFactory factor;
    public static int compNumber = 1;

    public SkiCompetitionBuilder(int N)
    {
    	
        factor = new ArenaFactory("winter", 700, SnowSurface.POWDER, WeatherCondition.SUNNY);
        skiComp = new SkiCompetition((WinterArena)factor.getArena(),N, Discipline.DOWNHILL, League.JUNIOR, Gender.MALE);

        Skier obj = new Skier("Skier"+compNumber,15,Gender.MALE,11,11,Discipline.DOWNHILL,"Blue");

        skiComp.addCompetitor(obj);

        for(int i=1; i< N; i++)
        {
            compNumber++;
            skiComp.addCompetitor(obj.makeCopy()); // prototype dp
        }
    }


}
