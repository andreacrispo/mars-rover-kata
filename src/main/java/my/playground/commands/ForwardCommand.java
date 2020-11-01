package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;

import java.util.Map;

public class ForwardCommand implements Command {

    private final Map<Direction,Position> forwardMapper = Map.of(
            Direction.NORTH, Position.Up(),
            Direction.EAST, Position.Right(),
            Direction.WEST, Position.Left(),
            Direction.SOUTH, Position.Down()
    );

    @Override
    public boolean applicable(CommandType commandType) {
        return commandType == CommandType.forward;
    }

    @Override
    public Position execute(Direction direction, Position currentPosition) {
        Position move = this.forwardMapper.get(direction);
        return new Position(currentPosition.getX() + move.getX(), currentPosition.getY() + move.getY());
    }
}
