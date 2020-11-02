package my.playground;


import my.playground.commands.*;

import java.util.List;

import static java.util.Arrays.asList;

public class Rover {

    private Position position;
    private Direction direction;

    private final List<Command> commands = asList(
            new ForwardCommand(),
            new BackwardCommand(),
            new TurnLeftCommand(),
            new TurnRightCommand()
    );

    public Rover(int x, int y, Direction direction) {
       this(new Position(x,y), direction);
    }

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
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

    public Position move(CommandType commandType) {
        return this.commands.stream()
                .filter(c -> c.applicable(commandType))
                .findFirst()
                .map( c -> c.execute(this))
                .get();
    }
}
