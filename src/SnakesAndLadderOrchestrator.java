import com.game.Event;
import com.game.model.*;

import java.util.ArrayList;
import java.util.List;

import static com.game.Event.WAIT;

public class SnakesAndLadderOrchestrator {

    public static Board initBoard(int size){
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(30,2));
        snakes.add(new Snake(54,11));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(21,80));
        ladders.add(new Ladder(51,73));

        Board board = new Board(size);
        board.addPieces(snakes);
        board.addPieces(ladders);
        return board;
    }

    public static void main(String[] args) {
        Board board = initBoard(100);
        int numberOfPlayers = 3, turn = 0;
        Player p1 = new Player("A");
        Player p2 = new Player("B");
        Player p3 = new Player("C");
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        while (true){
            Player p = players.get(turn);
            Event next = p.play(-1, board);
            if(next == Event.FINISH){
                break;
            }
            if(next == WAIT){
                turn = (turn+1)%3 ;
            }

        }


    }
}
