package my.playground;

import my.playground.commands.CommandType;
import org.junit.jupiter.api.Test;

import static my.playground.Direction.NORTH;
import static my.playground.Direction.WEST;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    public void ensure_rover_is_created_correctly() {
        Rover rover = new Rover(0,0, NORTH);

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    public void should_move_forward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        Rover rover = new Rover(0,y, NORTH);
        RoverEngine roverEngine = new RoverEngine(2,2, rover);
        Position newPosition =  rover.move(CommandType.forward);

        assertEquals(y+1, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 1;
        Rover rover = new Rover(0,y, NORTH);
        RoverEngine roverEngine = new RoverEngine(2,2, rover);
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(0,newPosition.getX());
        assertEquals(y-1, newPosition.getY());
    }

    @Test
    public void should_move_left_facing_north_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(x,y, NORTH);
        Position newPosition =  rover.move(CommandType.turnLeft);

        assertEquals(new Position(1,0), newPosition);
        assertEquals(WEST, rover.getDirection());
    }



    @Test
    public void should_move_forward_facing_east_when_no_obstacle_when_no_edge() {
        int x =0;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(x+1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_east_when_no_obstacle_when_no_edge() {
        int x=1;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(0,newPosition.getX());
        assertEquals(1, newPosition.getY());
    }




    @Test
    public void should_move_forward_facing_west_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(x,y, WEST);
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(x-1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_west_when_no_obstacle_when_no_edge() {
        int x=0;
        int y = 1;
        Rover rover = new Rover(x,y, WEST);
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(x+1,newPosition.getX());
        assertEquals(y, newPosition.getY());
    }


    @Test
    public void should_move_right_facing_west_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(x,y, WEST);
        Position newPosition =  rover.move(CommandType.turnRight);

        assertEquals(x, newPosition.getX());
        assertEquals(y, newPosition.getY());
        assertEquals( NORTH, rover.getDirection());
    }








    @Test
    public void should_move_forward_facing_south_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.SOUTH);
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(x, newPosition.getX());
        assertEquals(y-1, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_south_when_no_obstacle_when_no_edge() {
        int x=0;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.SOUTH);
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(x,newPosition.getX());
        assertEquals(y+1, newPosition.getY());
    }




}