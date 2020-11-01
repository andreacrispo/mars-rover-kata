package my.playground;

import java.util.Collections;
import java.util.List;

public class Mars {

    private int nRow;
    private int nCol;

    private int[][] land;

    private Rover rover;
    private List<Position> obstacles;

    public Mars(int nRow, int nCol, Rover rover) {
         this(nRow,nCol,rover, Collections.emptyList());
    }

    public Mars(int nRow, int nCol, Rover rover, List<Position> obstacles) {
        this.nRow = nRow;
        this.nCol = nCol;
        this.rover = rover;
        this.obstacles = obstacles;
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
        if(this.encounterAnObstacle()) {
            this.reportObstacle();
        }else{
            this.setPositionOnLand(newPosition);
        }
    }

    private void reportObstacle() {

    }

    private boolean encounterAnObstacle() {
        return false;
    }

    private void setPositionOnLand(Position newPosition) {
        this.land[newPosition.getX()][newPosition.getY()] = 1;
    }
}
