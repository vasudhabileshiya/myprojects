package com.game.model;

import com.game.Event;

public class Player {

    private Event event = Event.DICE_ROLL;
    private String name;
    private int position = 0;

    public Player(String name){
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int rollDice(){
        return (int)(Math.random()*6+1);
    }

    public Event play(final int diceValue, final Board board){
        return event.advance(diceValue,this, board);
    }
}
