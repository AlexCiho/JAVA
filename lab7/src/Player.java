public class Player implements  Runnable {
    private String name;
    private Game game;
    private Graph graph;
    private int size;

    Player(String name) {
        this.name = name;
        graph = new Graph();
    }

    private boolean play() throws InterruptedException {
        //Board board = game.getBoard();
        if (game.getBoard().isEmpty()) { return false; }
        graph.add( game.getBoard().extract() );
       // System.out.println(this.getName());
        //game.getBoard().getComplete().printGraph(this.getName());
        Thread.sleep(300);
        if (graph.isSpanningTree()) {
            game.setWinner(this);
            return false;
        }

        return true;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame( Game game ) {
        this.game = game;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public void run() {
        while (true) {
            try {
                if (!play()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
