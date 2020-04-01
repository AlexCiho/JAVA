public class Edge {
    private int firstVertex;
    private int secondVertex;

    Edge(int x, int y) {
        firstVertex = x;
        secondVertex = y;
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(int firstVertex) {
        this.firstVertex = firstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(int secondVertex) {
        this.secondVertex = secondVertex;
    }
}
