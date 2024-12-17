import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int currentIndex = 0;

    public ObjectArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("В массиве больше нет элементов");
        }
        return array[currentIndex++];
    }
}

