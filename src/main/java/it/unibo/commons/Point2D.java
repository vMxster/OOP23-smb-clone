package it.unibo.commons;

public class Point2D<X, Y> {
    private X x;
    private Y y;

    public Point2D(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }
    
    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
    
    public void setX(X x) {
        this.x = x;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public void set(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Point2D<X, Y> other = (Point2D<X, Y>) obj;
        if (x == null) {
            if (other.x != null) {
                return false;
            }
        } else if (!x.equals(other.x)) {
            return false;
        }
        if (y == null) {
            if (other.y != null) {
                return false;
            }
        } else if (!y.equals(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }

    public Point2D<X, Y> copy() {
        return new Point2D<>(this.getX(), this.getY());
    }
    
}
