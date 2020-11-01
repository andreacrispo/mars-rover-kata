package my.playground;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarsTest {


    @Test
    public void ensure_mars_is_created_correctly_with_rover() {
        Rover rover = new Rover(0,0, Direction.NORTH);
        Mars mars = new Mars(2,2, rover);
        int[][] land = mars.getLand();

        assertEquals(1, land[rover.getX()][rover.getY()]);
        assertEquals(0, land[1][1]);
    }

    @Test
    public void should_move_forward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 0;
        Rover rover = new Rover(0,y, Direction.NORTH);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.forward);

        assertEquals(1, mars.getLand()[0][1]);
    }


    @Test
    public void should_not_move_forward_facing_north_when_obstacle_but_when_no_edge() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.NORTH);
        List<Position> obstacles = Collections.singletonList(new Position(x, 1));
        Mars mars = new Mars(2,2, rover, obstacles);

        mars.moveRover(Command.forward);

        assertEquals(1, mars.getLand()[0][0]);
    }

    @Test
    public void should_move_backward_facing_north_when_no_obstacle_when_no_edge() {
        int y = 1;
        Rover rover = new Rover(0,y, Direction.NORTH);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.backward);
        assertEquals(1, mars.getLand()[0][0]);
    }

    @Test
    public void should_move_left_facing_north_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.NORTH);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.left);
        assertEquals(1, mars.getLand()[0][0]);
    }

    @Test
    public void should_move_right_facing_north_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.NORTH);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.right);
        assertEquals(1, mars.getLand()[1][0]);
    }


    @Test
    public void should_move_forward_facing_east_when_no_obstacle_when_no_edge() {
        int y = 0;
        Rover rover = new Rover(0,y, Direction.EAST);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.forward);

        assertEquals(1, mars.getLand()[1][0]);
    }

    @Test
    public void should_move_backward_facing_east_when_no_obstacle_when_no_edge() {
        int x = 1;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.EAST);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.backward);
        assertEquals(1, mars.getLand()[0][0]);
    }

    @Test
    public void should_move_left_facing_east_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.EAST);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.left);
        assertEquals(1, mars.getLand()[0][1]);
    }

    @Test
    public void should_move_right_facing_east_when_no_obstacle_when_no_edge() {
        int x = 0;
        int y = 1;
        Rover rover = new Rover(x,y, Direction.EAST);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.right);
        assertEquals(1, mars.getLand()[0][0]);
    }

}