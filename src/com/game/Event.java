package com.game;

import com.game.model.Board;
import com.game.model.Piece;
import com.game.model.Player;

public enum Event {
    FINISH{
        @Override
        public Event advance(int diceValue, Player player, final Board board) {
            return null;
        }
    },
    SPECIAL_MOVE {
        @Override
        public Event advance(int diceValue, Player player, final Board board) {
            Piece piece = board.getPieceAt(player.getPosition());
            player.setPosition(piece.move(player.getPosition()));
            System.out.println("Special move to : "+player.getPosition());
            if(diceValue == 6) {
                System.out.println(player.getName() + "get extra roll for rolling 6 in previous move");
                return DICE_ROLL.advance(diceValue,player,board);
            }
            return WAIT.advance(diceValue,player,board);
        }
    },

    SIMPLE_ADVANCING {
        @Override
        public Event advance(int diceValue, Player player, final Board board) {
            int nextPos = player.getPosition() + diceValue;
            if(nextPos > board.getSize())
                nextPos = player.getPosition();
            player.setPosition(nextPos);

            if(player.getPosition() == board.getSize()){
                System.out.println(player.getName() + " Won the game!!");
                return FINISH;
            }
            if(board.getPieceAt(player.getPosition()) != null){
                System.out.println(player.getName() + " Got special piece at position :"+ player.getPosition());
                return SPECIAL_MOVE.advance(diceValue,player,board);
            }
            if( diceValue == 6) {
                System.out.println(player.getName() + "get extra roll for rolling 6 in previous move");
                return DICE_ROLL;
            }
            return WAIT.advance(diceValue,player,board);
        }
    },
    DICE_ROLL {
        @Override
        public Event advance(int diceValue, Player player, Board board) {
            diceValue = player.rollDice();
            System.out.println(player.getName()+ " Advancing on Dice roll :"+diceValue);
            return SIMPLE_ADVANCING.advance(diceValue,player,board);
        }
    },
    WAIT {
        @Override
        public Event advance(int diceValue, Player player, final Board board) {
            if(diceValue == -1){
                System.out.println(player.getName() + " Exiting wait");
                return DICE_ROLL.advance(diceValue,player,board);
            }
            System.out.println(player.getName() + " Waiting for turn at "+player.getPosition());
            return WAIT;
        }
    };

    abstract public Event advance(final int diceValue, final Player player, final Board board);
}
