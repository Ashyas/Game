package game.entities;

import game.enums.State;

public interface ICompetitorState {
    void changeState(State newState);
    void destiny();
    State getState();

}
