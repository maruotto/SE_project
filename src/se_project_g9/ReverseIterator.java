package se_project_g9;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author group9
 */
public class ReverseIterator<E> implements Iterator<E> {

    List collection;
    int oldSize;
    int index;

    /**
     * constructor of class ReverseIterator
     *
     * @param list the list that will be iterated
     */
    public ReverseIterator(List<E> list) {
        collection = list;
        oldSize = list.size();
        index = oldSize;
    }

    /**
     *
     * @return true if the next() method returns an object
     */
    @Override
    public boolean hasNext() {
        if (oldSize != collection.size()) {
            return false;
        }
        if (index > 0 & index <= oldSize) {
            return true;
        }
        return false;

    }

    /**
     *
     * @return the next object that hasn't been visited yet
     */
    @Override
    public E next() {
        if (!hasNext()) {
            return null;
        }
        index--;
        return (E) collection.get(index);

    }

}
