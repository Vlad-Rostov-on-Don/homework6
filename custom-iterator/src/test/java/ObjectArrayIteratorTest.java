import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayIteratorTest {

    @Test
    void testIterationOverArray() {
        String[] strings = {"one", "two", "three"};
        ObjectArrayIterator<String> iterator = new ObjectArrayIterator<>(strings);

        assertTrue(iterator.hasNext());
        assertEquals("one", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("two", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("three", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEmptyArray() {
        Integer[] integers = {};
        ObjectArrayIterator<Integer> iterator = new ObjectArrayIterator<>(integers);

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testNextThrowsExceptionWhenNoMoreElements() {
        Double[] doubles = {1.1, 2.2};
        ObjectArrayIterator<Double> iterator = new ObjectArrayIterator<>(doubles);

        iterator.next();
        iterator.next();
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}

