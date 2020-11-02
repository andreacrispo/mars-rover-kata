package my.playground;

import java.util.Collections;
import java.util.List;

public class Mars {

    private final Position edgeTopRightPosition;
    private final Position edgeBottomLeftPosition;
    private final List<Position> obstacles;

    public Mars(int topRightX, int topRightY) {
        this(Position.at(topRightX, topRightY));
    }

    public Mars(int topRightX, int topRightY, List<Position> obstacles) {
        this(Position.at(topRightX, topRightY), obstacles);
    }

    public Mars(Position edgeTopRight) {
        this(edgeTopRight, Collections.EMPTY_LIST);
    }

    public Mars(Position edgeTopRight, List<Position> obstacles) {
        this.edgeTopRightPosition = edgeTopRight;
        this.edgeBottomLeftPosition = Position.at(0,0);
        this.obstacles = obstacles;
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


    public boolean isPresentAnObstacleAt(Position position) {
        return this.obstacles.contains(position);
    }

}