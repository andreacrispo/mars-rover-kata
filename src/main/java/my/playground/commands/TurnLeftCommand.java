package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;
import my.playground.Rover;

import java.util.Map;

public class TurnLeftCommand implements Command {

    private final Map<Direction,Direction> leftMapper = Map.of(
            Direction.NORTH, Direction.WEST,
            Direction.EAST, Direction.NORTH,
            Direction.WEST, Direction.SOUTH,
            Direction.SOUTH, Direction.EAST
    );

    @Override
    public boolean applicable(CommandType commandType) {
        return commandType == CommandType.turnLeft;
    }

    @Override
    public Position execute(Rover rover) {
        Direction direction = this.leftMapper.get(rover.getDirection());
        rover.setDirection(direction);
        return rover.getPosition();
    }
}
