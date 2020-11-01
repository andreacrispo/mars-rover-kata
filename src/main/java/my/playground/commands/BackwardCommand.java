package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;

import java.util.Map;

public class BackwardCommand implements  Command {

    private final Map<Direction,Position> backwardMapper = Map.of(
            Direction.NORTH, Position.Down(),
            Direction.EAST, Position.Left(),
            Direction.WEST, Position.Right(),
            Direction.SOUTH, Position.Up()
    );

    @Override
    public boolean applicable(CommandType commandType) {
        return commandType == CommandType.backward;
    }

    @Override
    public Position execute(Direction direction, Position currentPosition) {
        Position move = this.backwardMapper.get(direction);
        return new Position(currentPosition.getX() + move.getX(), currentPosition.getY() + move.getY());
    }

}
