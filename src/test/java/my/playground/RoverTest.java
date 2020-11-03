package my.playground;

import my.playground.commands.CommandType;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static my.playground.Direction.*;
import static my.playground.Position.at;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    public void ensure_rover_is_created_correctly() {
        Rover rover = new Rover(at(0,0), NORTH, new Mars(2,2));

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    public void should_move_forward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        Rover rover = new Rover(at(0,y), NORTH, new Mars(2,2));
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(y+1, newPosition.Y());
    }

    @Test
    public void should_move_backward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 1;
        Rover rover = new Rover(at(0,y), NORTH, new Mars(2,2));
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(0,newPosition.X());
        assertEquals(y-1, newPosition.Y());
    }

    @Test
    public void should_move_left_facing_north_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(at(x,y), NORTH, new Mars(2,2));
        Position newPosition =  rover.move(CommandType.turnLeft);

        assertEquals(new Position(1,0), newPosition);
        assertEquals(WEST, rover.getDirection());
    }



    @Test
    public void should_move_forward_facing_east_when_no_obstacle_when_no_edge() {
        int x =0;
        int y = 0;
        Rover rover = new Rover(at(x,y), EAST,new Mars(at(2,2)));
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(x+1, newPosition.X());
        assertEquals(y, newPosition.Y());
    }

    @Test
    public void should_move_backward_facing_east_when_no_obstacle_when_no_edge() {
        int x=1;
        int y = 1;
        Rover rover = new Rover(at(x,y), EAST, new Mars(at(2,2)));
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(0,newPosition.X());
        assertEquals(1, newPosition.Y());
    }




    @Test
    public void should_move_forward_facing_west_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(at(x,y), WEST ,new Mars(at(2,2)));
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(x-1, newPosition.X());
        assertEquals(y, newPosition.Y());
    }

    @Test
    public void should_move_backward_facing_west_when_no_obstacle_when_no_edge() {
        int x=0;
        int y = 1;
        Rover rover = new Rover(at(x,y), WEST,new Mars(at(2,2)));
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(x+1,newPosition.X());
        assertEquals(y, newPosition.Y());
    }


    @Test
    public void should_move_right_facing_west_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(at(x,y), WEST ,new Mars(at(2,2)));
        Position newPosition =  rover.move(CommandType.turnRight);

        assertEquals(x, newPosition.X());
        assertEquals(y, newPosition.Y());
        assertEquals( NORTH, rover.getDirection());
    }


    @Test
    public void should_move_forward_facing_south_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 1;
        Rover rover = new Rover(at(x,y), SOUTH, new Mars(at(2,2)));
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(x, newPosition.X());
        assertEquals(y-1, newPosition.Y());
    }

    @Test
    public void should_move_backward_facing_south_when_no_obstacle_when_no_edge() {
        int x=0;
        int y = 0;
        Rover rover = new Rover(at(x,y), SOUTH, new Mars(at(2,2)));
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(x,newPosition.X());
        assertEquals(y+1, newPosition.Y());
    }


    @Test
    public void should_turn_right_facing_east_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(at(x,y), EAST, new Mars(at(2,2)));
        rover.move(CommandType.turnRight);
        assertEquals(rover.getPosition(), rover.getPosition());
        assertEquals(Direction.SOUTH, rover.getDirection());
    }


    @Test
    public void should_move_based_on_list_of_commands() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(at(x,y), NORTH, new Mars(at(4,4)));
        rover.move("FFR");
        assertEquals(new Position(0,2), rover.getPosition());
        assertEquals(Direction.EAST, rover.getDirection());
    }


    @Test
    public void receiveCommandsShouldStopWhenObstacleIsFound()   {
        int expected = 2;
        List<Position> obstacles = Collections.singletonList(at(3, 9));
        Mars mars = new Mars(at(10, 10), obstacles);
        Rover rover = new Rover(at(1,9), Direction.EAST, mars);
        rover.move("FFF");
        assertEquals(expected, rover.getPosition().X());
    }

    @Test
    public void shouldReturnToBottomEdgeWhereEdgeTop()   {
        Mars mars = new Mars(at(2, 2));
        Rover rover = new Rover(at(0,0), NORTH, mars);
        rover.move("FFF");
        assertEquals(at(0,0), rover.getPosition());
    }

    @Test
    public void shouldReturnToLeftEdgeWhereEdgeRight()   {
        Mars mars = new Mars(at(2, 2));
        Rover rover = new Rover(at(0,0), EAST, mars);
        rover.move("FFF");
        assertEquals(at(0,0), rover.getPosition());
    }


    @Test
    public void shouldReturnToTopEdgeWhenGoBottomDown()   {
        Mars mars = new Mars(at(2, 2));
        Rover rover = new Rover(at(0,0), SOUTH, mars);
        rover.move("F");
        assertEquals(at(0,2), rover.getPosition());
    }



    @Test
    public void shouldReturnToEastWHenGoLeftWest()   {
        Mars mars = new Mars(at(2, 2));
        Rover rover = new Rover(0,0, WEST, mars);
        rover.move("F");
        assertEquals(at(2,0), rover.getPosition());
    }

}