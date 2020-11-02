package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;
import my.playground.Rover;

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
    public Position execute(Rover rover) {
        Position move = this.backwardMapper.get(rover.getDirection());
        return new Position(rover.getX() + move.X(), rover.getY() + move.Y());
    }

}
