package game.competition;

import game.arena.IArena;
import utilities.Point;
import utilities.ValidationUtils;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  
 * @author Asher Yasia and  Yogev Orenshtein.
 * 
 *  ID's : 310273370   and   200844272
 *  
 *  Campus : Beer - Sheva 
 *  
 */

public abstract class Competition {
    private IArena arena;
    protected final ArrayList<Competitor> activeCompetitors;
    protected final ArrayList<Competitor> finishedCompetitors;
    private final int maxCompetitors;
    private double y;

    public Competition(IArena arena, int maxCompetitors) {
        this.maxCompetitors = maxCompetitors;
        this.activeCompetitors = new ArrayList<>();
        this.finishedCompetitors = new ArrayList<>();
        this.arena = arena;
        y=0;
    }

    

    
    
	public void startCompetition(int threads) throws InterruptedException {

		ExecutorService e = Executors.newFixedThreadPool(threads);
		for (Competitor c : activeCompetitors) {
			e.execute(c);

		}
		e.shutdown();
	}


	
    public boolean hasActiveCompetitors(){
        return activeCompetitors.size() > 0;
    }

    protected abstract boolean isValidCompetitor(Competitor competitor);

    public void addCompetitor(Competitor competitor){
        ValidationUtils.assertNotNull(competitor);
        if(maxCompetitors <= activeCompetitors.size()){
            throw new IllegalStateException("WinterArena is full max = "+ maxCompetitors);
        }
        if(isValidCompetitor(competitor)){
        	Point start = new Point(0, y);
        	Point finish = new Point(arena.getLength(), y);
            competitor.initRace(start,finish,arena);
            activeCompetitors.add(competitor);
            y += 75;
        }
        else{
            throw new IllegalArgumentException("Invalid competitor "+ competitor);
        }
    }
    public ArrayList<Competitor> getFinishedCompetitors() {
        return new ArrayList<>(finishedCompetitors);
    }
    
    public ArrayList<Competitor> getActiveCompetitors() {
        return new ArrayList<>(activeCompetitors);
    }
    
    public void removeCompetitor(Competitor competitor){
        activeCompetitors.remove(competitor);
        finishedCompetitors.add(competitor);
    }
    

    @Deprecated
    public void playTurn(){
        ArrayList<Competitor> tmp = new ArrayList<>(activeCompetitors);
        for(Competitor competitor: tmp){
            if(!arena.isFinished(competitor)){
                competitor.move(arena.getFriction());
                if(arena.isFinished(competitor)){
                    finishedCompetitors.add(competitor);
                    activeCompetitors.remove(competitor);
                }
            }
        }
    }

}
