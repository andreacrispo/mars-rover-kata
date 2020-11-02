package my.playground;

public class Mars {


    private final Position edgeTopRightPosition;
    private Position edgeBottomLeftPosition;

    public Mars(int topRightX, int topRightY) {
        this(Position.at(topRightX, topRightY));
    }

    public Mars(Position edgeTopRight) {
        this.edgeTopRightPosition = edgeTopRight;
        this.edgeBottomLeftPosition = Position.at(0,0);
    }


    public Position checkEdge(Position nextPosition) {
        if(nextPosition.getX() > this.edgeTopRightPosition.getX())
            return new Position(edgeBottomLeftPosition.getX(), nextPosition.getY());

        if(nextPosition.getY() >= this.edgeTopRightPosition.getX())
            return new Position(nextPosition.getX(), edgeBottomLeftPosition.getY());

        if(nextPosition.getX() < this.edgeBottomLeftPosition.getX())
            return new Position(this.edgeTopRightPosition.getX() -1, nextPosition.getY());
        if(nextPosition.getY() < this.edgeBottomLeftPosition.getY())
            return new Position(nextPosition.getX(), this.edgeTopRightPosition.getY() -1);

        return nextPosition;
    }

}