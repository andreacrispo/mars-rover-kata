package my.playground.commands;

import my.playground.Direction;
import my.playground.Position;

public interface Command {

    boolean applicable(CommandType commandType);

    Position execute(Direction direction, Position currentPosition);

}
