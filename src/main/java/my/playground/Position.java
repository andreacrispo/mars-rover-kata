package my.playground;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int X() {
        return x;
    }

    public int Y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static Position Up() { return new Position(0, 1); }
    public static Position Down() { return new Position(0, -1); }
    public static Position Left() { return new Position(-1, 0); }
    public static Position Right() { return new Position(1, 0); }

    public static Position at(int x, int y) { return new Position(x,y); }

}