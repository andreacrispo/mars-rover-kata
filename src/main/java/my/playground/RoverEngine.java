package my.playground;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RoverEngine {

    private final Mars mars;
    private final Rover rover;
    private final List<Position> obstacles;

    private final Map<Character, Command> commandMapper = Map.of(
            'L', Command.left,
            'R', Command.left,
            'B', Command.backward,
            'F', Command.forward
    );

    public RoverEngine(int nRow, int nCol, Rover rover) {
         this(nRow,nCol,rover, Collections.emptyList());
    }

    public RoverEngine(int nRow, int nCol, Rover rover, List<Position> obstacles) {
        this.mars = new Mars(nRow,nCol);
        this.rover = rover;
        this.obstacles = obstacles;
        mars.createGrid();
        mars.placeRover(this.rover);
    }

    public RoverEngine(Mars mars, Rover rover, List<Position> obstacles) {
        this.mars = mars;
        this.rover = rover;
        this.obstacles = obstacles;
        mars.createGrid();
        mars.placeRover(this.rover);
    }


    public int[][] getLand() {
      return this.mars.land;
    }


    public void moveRover(String command) {
        for(int i=0; i < command.length(); i++) {
            this.moveRover(command.charAt(i));
        }
    }

    public void moveRover(char singleCommand) {
        Command command =  this.commandMapper.get(singleCommand);
        this.moveRover(command);
    }

    public void moveRover(Command command) {
        Position oldPosition = this.rover.getPosition();
        Position nextPosition = this.rover.move(command);
        if(this.encounterAnObstacle(nextPosition)) {
            this.reportObstacle();
        }
        else{
            nextPosition = checkEdge(nextPosition);
            this.setPositionOnLand(oldPosition, nextPosition);
        }
    }

    private Position checkEdge(Position nextPosition) {
        if(nextPosition.getX() >= mars.nRow)
            return new Position(0, nextPosition.getY());
        if(nextPosition.getY() >= mars.nCol)
            return  new Position(nextPosition.getX(), 0);
        if(nextPosition.getX() < 0)
            return new Position(mars.nRow -1, nextPosition.getY());
        if(nextPosition.getY() < 0)
            return new Position(nextPosition.getX(), mars.nCol -1);

        return nextPosition;
    }

    private void reportObstacle() {

    }

    private boolean encounterAnObstacle(Position position) {
        return this.obstacles.contains(position);
    }

    private void setPositionOnLand(Position oldPosition, Position newPosition) {
        this.mars.land[oldPosition.getX()][oldPosition.getX()] = 0;
        this.mars.land[newPosition.getX()][newPosition.getY()] = 1;
    }



    public void debug() {
        for(int i = 0; i< mars.nRow; i++) {
            for(int j = 0; j< mars.nCol; j++) {
                System.out.println("land["+i+"]"+"["+j+"]" + mars.land[i][j]);
            }
        }
    }
}
