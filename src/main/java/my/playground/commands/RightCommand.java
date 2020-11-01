package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;

import java.util.Map;

public class RightCommand  implements Command {


    private final Map<Direction,Position> rightMapper = Map.of(
            Direction.NORTH, Position.Right(),
            Direction.EAST, Position.Down(),
            Direction.WEST, Position.Up(),
            Direction.SOUTH, Position.Left()
    );

    @Override
    public boolean applicable(CommandType commandType) {
        return commandType == CommandType.right;
    }

    @Override
    public Position execute(Direction direction, Position currentPosition) {
        Position move = this.rightMapper.get(direction);
        return new Position(currentPosition.getX() + move.getX(), currentPosition.getY() + move.getY());
    }
}
