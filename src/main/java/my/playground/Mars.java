package my.playground;

public class Mars {

    int nRow;
    int nCol;
    int[][] land;

    private final Position edgeTopRightPosition;
    private Position edgeBottomLeftPosition;

    public Mars(int nRow, int nCol) {
        this.nRow = nRow;
        this.nCol = nCol;
        this.edgeTopRightPosition = new Position(nRow, nCol);
        this.createGrid();
    }

    public Mars(Position edgeTopRight) {
        this.edgeTopRightPosition = edgeTopRight;
        this.edgeBottomLeftPosition = new Position(0,0);
    }


    public Position checkEdge(Position nextPosition) {
        if(nextPosition.getX() > this.edgeTopRightPosition.getX())
            return new Position(edgeBottomLeftPosition.getX(), nextPosition.getY());
        if(nextPosition.getY() >= this.edgeTopRightPosition.getX())
            return new Position(nextPosition.getX(), edgeBottomLeftPosition.getY());
        if(nextPosition.getX() < 0)
            return new Position(this.edgeTopRightPosition.getX() -1, nextPosition.getY());
        if(nextPosition.getY() < 0)
            return new Position(nextPosition.getX(), this.edgeTopRightPosition.getY() -1);

        return nextPosition;
    }


    void createGrid() {
        this.land = new int[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
               this.land[i][j] = 0;
            }
        }
    }

    public void placeRover(Rover rover) {
        this.land[rover.getX()][rover.getY()] = 1;
    }

}