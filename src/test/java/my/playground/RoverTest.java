package my.playground;

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
        Mars mars = new Mars(2,2, rover);
        Position newPosition =  rover.move(Command.forward);

        assertEquals(y+1, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 1;
        Rover rover = new Rover(0,y, Direction.NORTH);
        Mars mars = new Mars(2,2, rover);
        Position newPosition =  rover.move(Command.backward);

        assertEquals(0,newPosition.getX());
        assertEquals(y-1, newPosition.getY());
    }

    @Test
    public void should_move_left_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        int x = 1;
        Rover rover = new Rover(x,y, Direction.NORTH);
        Position newPosition =  rover.move(Command.left);

        assertEquals(x-1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }


    @Test
    public void should_move_right_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        int x = 0;
        Rover rover = new Rover(x,y, Direction.NORTH);
        Position newPosition =  rover.move(Command.right);

        assertEquals(x+1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }


    @Test
    public void should_move_forward_facing_east_when_no_obstacle_when_no_edge() {
        int x =0;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(Command.forward);
        assertEquals(x+1, newPosition.getX());
        assertEquals(y, newPosition.getY());
    }

    @Test
    public void should_move_backward_facing_east_when_no_obstacle_when_no_edge() {
        int x=1;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(Command.backward);

        assertEquals(x-1,newPosition.getX());
        assertEquals(y, newPosition.getY());
    }

    @Test
    public void should_move_left_facing_east_when_no_obstacle_when_no_edge() {
        int y = 0;
        int x = 0;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(Command.left);

        assertEquals(x, newPosition.getX());
        assertEquals(y +1, newPosition.getY());
    }


    @Test
    public void should_move_right_facing_east_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.EAST);
        Position newPosition =  rover.move(Command.right);

        assertEquals(x, newPosition.getX());
        assertEquals(y-1, newPosition.getY());
    }














}