package game.entities;

import utilities.Point;

/**
 * Created by itzhak on 07-Mar-19.
 */
public class MobileEntity extends Entity implements IMobileEntity{
    private final double maxSpeed;
    private double acceleration;
    private double speed;


    /**
     * Ctor for a mobile entity in the game
     * @param initialSpeed initial speed of the entity
     * @param acceleration entity acceleration
     * @param maxSpeed entity maximum speed
     */
    public MobileEntity( double initialSpeed,double acceleration, double maxSpeed){
        this.setSpeed(initialSpeed);
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;

    }

    //region IMobileEntity Implementation

    /**
     * @see IMobileEntity#move(double)
     */
    @Override
    public void move(double friction) {
        this.setSpeed(Math.min(this.maxSpeed,this.speed + this.getAcceleration()* (1-friction)));
        Point newLocation = this.getLocation().offset(this.speed,0);

        if (newLocation.getX() > this.getLocation().getX() + (int)(speed/2)){ //you can change to number like 7 / 8
            setChanged();
            this.notifyObservers();
        }
        this.setLocation(newLocation);

    }




   
    /**
     * Note: speed can theoretically be negative
     * @param speed the current speed of the entity
     */
    private void setSpeed(double speed) {
        this.speed = speed;
    }
    

    /**
     * @return the acceleration of the entity
     */
    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration){
        this.acceleration = acceleration;
    }
    
    
    public double getSpeed() {
    	return speed;
    }
    
    public double getMaxSpeed() {
    	return maxSpeed;
    }
    //endregion

}
