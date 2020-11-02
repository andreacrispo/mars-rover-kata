package my.playground.commands;

import my.playground.Position;
import my.playground.Rover;

public interface Command {

    boolean applicable(CommandType commandType);

    Position execute(Rover rover);

}
