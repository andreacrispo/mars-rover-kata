package my.playground;

import my.playground.commands.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    public void ensure_rover_is_created_correctly() {
        Rover rover = new Rover(0,0, Direction.NORTH);

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void should_move_forward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        Rover rover = new Rover(0,y, Direction.NORTH);
        RoverEngine roverEngine = new RoverEngine(2,2, rover);
        Position newPosition =  rover.move(CommandType.forward);

        assertEquals(y+1, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 1;
        Rover rover = new Rover(0,y, Direction.NORTH);
        RoverEngine roverEngine = new RoverEngine(2,2, rover);
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(0,newPosition.getX());
        assertEquals(y-1, newPosition.getY());
    }

    @Test
    public void should_move_left_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        int x = 1;
        Rover rover = new Rover(x,y, Direction.NORTH);
        Position newPosition =  rover.move(CommandType.left);

        assertEquals(x-1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }


    @Test
    public void should_move_right_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        int x = 0;
        Rover rover = new Rover(x,y, Direction.NORTH);
        Position newPosition =  rover.move(CommandType.right);

        assertEquals(x+1, newPosition.getX());
        assertEquals(y, newPosition.getY());
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
    public void should_move_left_facing_east_when_no_obstacle_when_no_edge() {
        int y = 0;
        int x = 0;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(CommandType.left);

        assertEquals(0, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }


    @Test
    public void should_move_right_facing_east_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(CommandType.right);

        assertEquals(0, newPosition.getX());
        assertEquals(0, newPosition.getY());
    }


    @Test
    public void should_move_forward_facing_west_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.WEST);
        Position newPosition =  rover.move(CommandType.forward);
        assertEquals(x-1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_west_when_no_obstacle_when_no_edge() {
        int x=0;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.WEST);
        Position newPosition =  rover.move(CommandType.backward);

        assertEquals(x+1,newPosition.getX());
        assertEquals(y, newPosition.getY());
    }

    @Test
    public void should_move_left_facing_west_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.WEST);
        Position newPosition =  rover.move(CommandType.left);

        assertEquals(x, newPosition.getX());
        assertEquals(y - 1, newPosition.getY());
    }


    @Test
    public void should_move_right_facing_west_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.WEST);
        Position newPosition =  rover.move(CommandType.right);

        assertEquals(x, newPosition.getX());
        assertEquals(y+1, newPosition.getY());
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

    @Test
    public void should_move_left_facing_south_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.SOUTH);
        Position newPosition =  rover.move(CommandType.left);

        assertEquals(x+1 , newPosition.getX());

        assertEquals(y, newPosition.getY());
    }


    @Test
    public void should_move_right_facing_south_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.SOUTH);
        Position newPosition =  rover.move(CommandType.right);

        assertEquals(x -1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }


}