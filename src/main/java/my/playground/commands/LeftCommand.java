package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;

import java.util.Map;

public class LeftCommand implements Command {

    private final Map<Direction,Position> leftMapper = Map.of(
            Direction.NORTH, Position.Left(),
            Direction.EAST, Position.Up(),
            Direction.WEST, Position.Down(),
            Direction.SOUTH, Position.Right()
    );

    @Override
    public boolean applicable(CommandType commandType) {
        return commandType == CommandType.left;
    }

    @Override
    public Position execute(Direction direction, Position currentPosition) {
        Position move = this.leftMapper.get(direction);
        return new Position(currentPosition.getX() + move.getX(), currentPosition.getY() + move.getY());
    }
}
