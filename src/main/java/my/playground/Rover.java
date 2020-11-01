package my.playground;

public class Rover {

    private Position position;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.position = new Position(x,y);
        this.direction = direction;
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        position.setY(y);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position move(Command command) {
        int x = this.getX();
        int y = this.getY();
        switch (this.direction){
            case NORTH:
                switch (command) {
                    case forward:
                        return new Position(x, y +1);
                    case backward:
                        return new Position(x, y -1);
                    case left:
                        return new Position(x -1, y);
                    case right:
                        return new Position(x +1, y);
                }
                break;
            default:
                throw new RuntimeException();
        }
        return null;
    }
}
