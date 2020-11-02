package my.playground.commands;

import my.playground.Position;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class RoverCommand {

    private final List<Command> commands = asList(
            new ForwardCommand(),
            new BackwardCommand(),
            new TurnLeftCommand(),
            new TurnRightCommand()
    );

    private final Map<Character, CommandType> commandMapper = Map.of(
            'L', CommandType.turnLeft,
            'R', CommandType.turnRight,
            'B', CommandType.backward,
            'F', CommandType.forward
    );


    public Command getBy(CommandType commandType) {
        return this.commands.stream()
                .filter(c -> c.applicable(commandType))
                .findFirst()
                .get();
    }

    public CommandType ofChar(char singleCommand) {
        return commandMapper.get(singleCommand);
    }

}
