package com.game.model;

public class Ladder extends Piece {

    private int bottom;
    private int top;

    public Ladder(int bottom, int top) {
        this.bottom = bottom;
        this.top = top;
    }

    @Override
    public int move(int start) {
        System.out.println("Climbing Ladder!!");
        assert start == bottom;
        return top;
    }

    @Override
    protected int getIndex() {
        return bottom;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "bottom=" + bottom +
                ", top=" + top +
                '}';
    }
}
