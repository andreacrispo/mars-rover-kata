package my.playground;

public class Mars {

    private final int nRow;
    private final int nCol;

    private int[][] land;

    private Rover rover;

    public Mars(int nRow, int nCol, Rover rover) {
        this.nRow = nRow;
        this.nCol = nCol;
        this.rover = rover;
        this.createGrid();
    }

    private void createGrid() {
        this.land = new int[nRow][nCol];
        for(int i=0; i< nRow; i++) {
            for(int j=0; j<nCol; j++) {
                if( i == rover.getX() && j == rover.getY())
                    this.land[i][j] = 1;
                else
                    this.land[i][j] = 0;
            }
        }
    }

    public int[][] getLand() {
      return this.land;
    }


    public void moveRover(Command command) {
        Position newPosition = this.rover.move(command);
        this.setPositionOnLand(newPosition);
    }

    private void setPositionOnLand(Position newPosition) {
        this.land[newPosition.getX()][newPosition.getY()] = 1;
    }
}
