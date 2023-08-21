package org.example;

public class Coords {
    Integer x;
    Integer y;

    public Coords (Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof Coords))
            return false;
        Coords other = (Coords) o;
        return this.x.equals(other.x) && this.y.equals(other.y);
    }

    @Override
    public final int hashCode() {
        String t = this.x.toString() + this.y.toString();
        int hash = Integer.parseInt(t);
        return hash;
    }
}
