package my.playground;

import my.playground.commands.*;

public class Rover {

    private Position position;
    private Direction direction;
    private final Mars mars;
    private final RoverCommand commands;

    public Rover(int x, int y, Direction direction, Mars mars) {
        this(Position.at(x, y), direction, mars);
    }


    public Rover(Position position, Direction direction, Mars mars) {
        this.position = position;
        this.direction = direction;
        this.mars = mars;
        this.commands = new RoverCommand();
    }

    public int getX() {
        return position.X();
    }

    public int getY() {
        return position.Y();
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


    public void move(String command) {
        for (int i = 0; i < command.length(); i++) {
            this.move(command.charAt(i));
        }
    }

    public void move(char singleCommand) {
        this.move(this.commands.ofChar(singleCommand));
    }

    public Position move(CommandType commandType) {
        Position nextPosition = commands.getBy(commandType).execute(this);
        if (this.mars.isPresentAnObstacleAt(nextPosition)) {
            this.reportObstacle(nextPosition);
        } else {
            this.position = this.mars.checkEdge(nextPosition);
        }

        return this.position;
    }

    private void reportObstacle(Position nextPosition) {
        System.out.println("Found an obstacle in " + nextPosition.toString());
    }

}
