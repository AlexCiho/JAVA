public class Board {

    private final Graph complete;
    int counter = 0;
    public int size ;

    public Board(int n) {
        // create the complete graph
        // shuffle its edges
        complete = new Graph();
        size = n;
        for (int i = 1 ; i <= n; i++) {
            for (int j = i + 1 ; j <= n; j++) {

                    complete.add(new Edge(i,j));
                    counter++;

            }
        }
        complete.shuffle();
        //complete.printGraph();


    }
    public synchronized Edge extract() {
        // replace the dots so that the board is thread-safe
        Edge edge = complete.pollFirst();
        counter--;
        return edge;
    }
    public boolean isEmpty() {
        if (counter > 0) {
            return false;
        } else {
        return true;
        }
    }
    Graph getComplete() {
        return complete;
    }
}
