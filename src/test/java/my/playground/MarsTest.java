package my.playground;

import org.junit.jupiter.api.Test;

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
        int x = 1;
        int y = 0;
        Rover rover = new Rover(x,y, Direction.NORTH);
        Mars mars = new Mars(2,2, rover);

        mars.moveRover(Command.left);
        assertEquals(1, mars.getLand()[1][0]);
    }

}