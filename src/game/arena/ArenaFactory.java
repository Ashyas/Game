package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;

/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */

public class ArenaFactory {
    IArena arena;
    
    

    public ArenaFactory(String type, double length, SnowSurface surface, WeatherCondition condition){
    	
    	/*function that checks the type of the arena
         * then creates a new instance of it*/
    	
        if(type == "summer"){
            arena = new SummerArena(length,surface,condition);
        }
        else{
            arena = new WinterArena(length,surface,condition);
        }
    }

    public IArena getArena(){
        return arena;
    }
}
