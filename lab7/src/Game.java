import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private final List<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public Board getBoard() {
        return board;
    }
    public void setWinner(Player p) {
        System.out.println("Player " + p.getName() + " won " );
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void start() {
        for( Player p : players ) {
            new Thread(p).start();
        }
    }


    //Create getters and setters
    //Create the method that will start the game: start one thread for each player
}
