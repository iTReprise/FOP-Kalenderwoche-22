package aufgabe2;

import java.lang.Comparable;

public class Pair<A, B> implements Comparable {

    final A first;
    final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return second != null ? second.equals(pair.second) : pair.second == null;
    }

    /* own implementation for equals (:
    @Override
    public boolean equals(Object o) {

        try {
            if (first.equals(((Pair) o).first) && second.equals(((Pair) o).second)) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }*/

    public Pair<B, A> swap() {
        return new Pair<>(this.second, this.first);
    }

    @Override
    public int compareTo(Object o) {
        Pair test = (Pair) o;
        return this.first.equals(test.first) ? this.second.toString().compareTo(test.second.toString()) : this.first.toString().compareTo(test.first.toString());
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}