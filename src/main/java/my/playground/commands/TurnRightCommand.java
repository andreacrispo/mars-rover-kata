package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;
import my.playground.Rover;

import java.util.Map;

public class TurnRightCommand implements Command {


    private final Map<Direction,Direction> rightMapper = Map.of(
            Direction.NORTH, Direction.EAST,
            Direction.EAST, Direction.SOUTH,
            Direction.WEST, Direction.NORTH,
            Direction.SOUTH, Direction.WEST
    );

    @Override
    public boolean applicable(CommandType commandType) {
        return commandType == CommandType.turnRight;
    }

    @Override
    public Position execute(Rover rover) {
        Direction direction = this.rightMapper.get(rover.getDirection());
        rover.setDirection(direction);
        return rover.getPosition();
    }
}
