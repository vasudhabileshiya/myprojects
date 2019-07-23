package com.game.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    protected int size;
   // protected List<? super Piece> pieces = new ArrayList<>();
    Map<Integer, Piece> indexVsPieceMap = new HashMap<>();

    public Board(int size){
       this.size = size;
    }

    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    public void addPieces(List<? extends Piece> pieces){
        //this.pieces.addAll(pieces);
        for(Piece p : pieces){
            indexVsPieceMap.put(p.getIndex(),p);
        }
    }

    public Piece getPieceAt(int position){
        return indexVsPieceMap.get(position);
    }

}

