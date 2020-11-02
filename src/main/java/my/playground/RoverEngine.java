package my.playground;

import my.playground.commands.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class RoverEngine {

    private final Mars mars;
    private final Rover rover;
    private final List<Position> obstacles;

    public RoverEngine(int nRow, int nCol, Rover rover) {
         this(nRow,nCol,rover, Collections.emptyList());
    }

    public RoverEngine(int nRow, int nCol, Rover rover, List<Position> obstacles) {
        this(new Mars(nRow, nCol), rover, obstacles);
    }

    public RoverEngine(Mars mars, Rover rover) {
         this(mars, rover, Collections.emptyList());
    }

    public RoverEngine(Mars mars, Rover rover, List<Position> obstacles) {
        this.mars = mars;
        this.rover = rover;
        this.obstacles = obstacles;
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
        CommandType commandType = this.commandMapper.get(singleCommand);
        this.moveRover(commandType);
    }

    public void moveRover(CommandType commandType) {
        Position oldPosition = this.rover.getPosition();
        Position nextPosition = this.rover.move(commandType);
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
        this.rover.setPosition(newPosition);
    }


    public Rover getRover() {
        return rover;
    }

    public void debug() {
        for(int i = 0; i< mars.nRow; i++) {
            for(int j = 0; j< mars.nCol; j++) {
                System.out.println("land["+i+"]"+"["+j+"]" + mars.land[i][j]);
            }
        }
    }


    private final Map<Character, CommandType> commandMapper = Map.of(
            'L', CommandType.turnLeft,
            'R', CommandType.turnRight,
            'B', CommandType.backward,
            'F', CommandType.forward
    );
}
