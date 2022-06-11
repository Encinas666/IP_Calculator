package main.Algoritmos;

import java.util.Objects;

public final class Quadrant {
    private final long quadrant;

    public Quadrant(long quadrant) {
        this.quadrant = quadrant;
    }

    public long quadrant() {
        return quadrant;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Quadrant) obj;
        return this.quadrant == that.quadrant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quadrant);
    }

    @Override
    public String toString() {
        return "" + quadrant;
    }

}
