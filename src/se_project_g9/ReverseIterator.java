package se_project_g9;


import java.util.Iterator;
import java.util.List;

/**
 *
 * @author group9
 */
public class ReverseIterator<E> implements Iterator<E>{
    
    List collection;
    int oldSize;
    int index;

    public ReverseIterator(List<E> list) {
        collection = list;
        oldSize = list.size();
        index = oldSize;
    }
    
    @Override
    public boolean hasNext(){
        if (oldSize != collection.size())
            return false;
        if (index > 0 & index <= oldSize)
            return true;
        return false;
            
    }

    @Override
    public E next() {
        if (!hasNext())
            return null;      
    index--;
    return (E) collection.get(index);
        
        
        
    }
    
    
    
}
