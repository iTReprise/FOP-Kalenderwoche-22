package aufgabe2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    public void testConstructor() {
        Assertions.assertEquals((Integer) 42, new Pair<>(42, false).first);
        Assertions.assertEquals(false, new Pair<>(42, false).second);
    }

    @Test
    public void testEquals() {
        Assertions.assertEquals(true, new Pair(42, false).equals(new Pair(42, false)));
        Assertions.assertEquals(false, new Pair(42, false).equals(new Pair(24, false)));
        Assertions.assertEquals(false, new Pair(42, false).equals(new Pair(42, true)));
        Assertions.assertEquals(false, new Pair(42, false).equals(new Pair(24, true)));

        Assertions.assertEquals(false, new Pair(42, false).equals(new Pair(24, 42)));
    }

    @Test
    public void testSwap() {
        Pair<Integer, Boolean> p = new Pair<>(42, false);
        Assertions.assertEquals(p, p.swap().swap());
    }

    @Test
    public void testCompareInteger() {

        List<Pair> xs = new ArrayList<>();
        xs.add(new Pair<>(1, 3));
        xs.add(new Pair<>(1, 1));
        xs.add(new Pair<>(4, 4));
        xs.add(new Pair<>(2, 1));
        xs.add(new Pair<>(1, 1));
        xs.add(new Pair<>(1, 3));
        xs.add(new Pair<>(2, 1));
        xs.add(new Pair<>(3, 1));
        System.out.println("unsorted list-1: " + xs);

        List<Pair> expectedList = new ArrayList<>();
        expectedList.add(new Pair<>(1, 1));
        expectedList.add(new Pair<>(1, 1));
        expectedList.add(new Pair<>(1, 3));
        expectedList.add(new Pair<>(1, 3));
        expectedList.add(new Pair<>(2, 1));
        expectedList.add(new Pair<>(2, 1));
        expectedList.add(new Pair<>(3, 1));
        expectedList.add(new Pair<>(4, 4));
        System.out.println("expected list-1: " + expectedList);

        Collections.sort(xs, Pair::compareTo);
        System.out.println("sorted list-1: " + xs);

        assertEquals(expectedList, xs);
    }

    @Test
    public void testCompareBoolean() {

        List<Pair> xs = new ArrayList<>();
        xs.add(new Pair<>(true, true));
        xs.add(new Pair<>(false, false));
        xs.add(new Pair<>(false, true));
        xs.add(new Pair<>(true, false));
        System.out.println("unsorted list-2: " + xs);

        List<Pair> expectedList = new ArrayList<>();
        expectedList.add(new Pair<>(false, false));
        expectedList.add(new Pair<>(false, true));
        expectedList.add(new Pair<>(true, false));
        expectedList.add(new Pair<>(true, true));
        System.out.println("expected list-2: " + expectedList);

        Collections.sort(xs, Pair::compareTo);
        System.out.println("sorted list-2: " + xs);

        assertEquals(expectedList, xs);
    }


}
