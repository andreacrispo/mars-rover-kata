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
        Position oldPosition = this.rover.getPosition();
        Position newPosition = this.rover.move(command);
        if(this.encounterAnObstacle(newPosition)) {
            this.reportObstacle();
        }else{
            this.setPositionOnLand(oldPosition, newPosition);
        }
    }

    private void reportObstacle() {

    }

    private boolean encounterAnObstacle(Position position) {
        return this.obstacles.contains(position);
    }

    private void setPositionOnLand(Position oldPosition, Position newPosition) {
        this.land[oldPosition.getX()][oldPosition.getX()] = 0;
        this.land[newPosition.getX()][newPosition.getY()] = 1;
    }
}
