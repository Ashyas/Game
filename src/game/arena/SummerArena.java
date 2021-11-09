package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import utilities.ValidationUtils;


/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */

public class SummerArena implements IArena {
	

    private final double length;
    private final SnowSurface surface;
    private final WeatherCondition condition;


    /**
     * Ctor for a generic arena
     * @param length the length of the arena
     * @param surface the snow surface of the arena
     * @param condition the weather condition in the arena
     */
    public SummerArena(double length, SnowSurface surface, WeatherCondition condition) {
        this.length = length;
        this.surface = surface;
        this.condition = condition;
    }

    @Override
    public double getFriction(){
        return surface.getFriction();
    }

    @Override
    public boolean isFinished(IMobileEntity mobileEntity) {
        ValidationUtils.assertNotNull(mobileEntity);
        return mobileEntity.getLocation().getX() >= length;
    }

    public double getLength() {
        return length;
    }
}
