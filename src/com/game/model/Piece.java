package com.game.model;

// abstract class , with function called move, which takes the initial position and return final position
public abstract class Piece {

    abstract public int move(int start);
    abstract protected  int getIndex();
}

