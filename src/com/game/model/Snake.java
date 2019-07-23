package com.game.model;

public class Snake extends Piece {
    private int head;
    private int tail;
    public Snake(int head, int tail){
        super();
        this.head = head;
        this.tail = tail;
    }
    @Override
    public int move(int start) {
        System.out.println("Snake Bite!!");
        assert start == head;
        return tail;
    }

    @Override
    protected int getIndex() {
        return head;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Snake{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
