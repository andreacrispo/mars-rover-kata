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
        int edgeTopX    = edgeTopRightPosition.X();
        int edgeTopY    = edgeTopRightPosition.Y();
        int edgeBottomX = edgeBottomLeftPosition.X();
        int edgeBottomY = edgeBottomLeftPosition.Y();

        if(nextPosition.X() > edgeTopX)
            return new Position(edgeBottomX, nextPosition.Y());

        if(nextPosition.Y() > edgeTopX)
            return new Position(nextPosition.X(), edgeBottomY);

        if(nextPosition.X() <  edgeBottomX)
            return new Position(edgeTopX -1, nextPosition.Y());

        if(nextPosition.Y() < edgeBottomY)
            return new Position(nextPosition.X(), edgeTopY -1);


        return nextPosition;
    }


    public boolean isPresentAnObstacleAt(Position position) {
        return this.obstacles.contains(position);
    }

}