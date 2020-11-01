package my.playground;

public class Mars {

    int nRow;
    int nCol;
    int[][] land;

    public Mars(int nRow, int nCol) {
        this.nRow = nRow;
        this.nCol = nCol;
        this.createGrid();
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