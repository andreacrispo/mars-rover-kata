package my.playground;
import my.playground.commands.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Rover {

    private Position position;
    private Direction direction;
    private Mars mars;
    private final List<Position> obstacles;

    private final List<Command> commands = asList(
            new ForwardCommand(),
            new BackwardCommand(),
            new TurnLeftCommand(),
            new TurnRightCommand()
    );

    public Rover(int x, int y, Direction direction,Mars mars) {
       this(new Position(x,y), direction,mars, Collections.EMPTY_LIST);
    }

    public Rover(Position position, Direction direction,Mars mars) {
        this(position, direction,mars,Collections.EMPTY_LIST);
    }

    public Rover(Position position, Direction direction, Mars mars, List<Position> obstacles) {
        this.position = position;
        this.direction = direction;
        this.mars = mars;
        this.obstacles = obstacles;
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        position.setY(y);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public void move(String command) {
        for(int i=0; i < command.length(); i++) {
            this.move(command.charAt(i));
        }
    }

    public void move(char singleCommand) {
        CommandType commandType = this.commandMapper.get(singleCommand);
        this.move(commandType);
    }

    public Position move(CommandType commandType) {
        Position nextPosition =  this.commands.stream()
                .filter(c -> c.applicable(commandType))
                .findFirst()
                .map( c -> c.execute(this))
                .get();

        if(this.encounterAnObstacle(nextPosition)) {
            //this.reportObstacle();
        }
        else{
          this.position = this.mars.checkEdge(nextPosition);
        }

        return nextPosition;
    }


    private boolean encounterAnObstacle(Position nextPosition) {
        return this.obstacles.contains(nextPosition);
    }




    private final Map<Character, CommandType> commandMapper = Map.of(
            'L', CommandType.turnLeft,
            'R', CommandType.turnRight,
            'B', CommandType.backward,
            'F', CommandType.forward
    );

}
