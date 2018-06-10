package ch21;

import java.util.*;

class ArrayBunchList<E> extends AbstractList<E> {

    private final E[][] arrays;
    private final int size;

    public ArrayBunchList(E[][] arrays) {
        this.arrays = arrays.clone();
        int s = 0;
        for (E[] array : arrays) {
            s += array.length;
        }
        size = s;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        int off = 0; // offset from start of collection
        for (int i = 0; i < arrays.length; i++) {
            if (index < off + arrays[i].length) {
                return arrays[i][index - off];
            }
            off += arrays[i].length;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    @Override
    public E set(int index, E value) {
        int off = 0; // offset from start of collection
        for (int i = 0; i < arrays.length; i++) {
            if (index < off + arrays[i].length) {
                E ret = arrays[i][index - off];
                arrays[i][index - off] = value;
                return ret;
            }
            off += arrays[i].length;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }
}

class ShortStrings implements Iterator<String> {

    private Iterator<String> strings; // source for strings
    private String nextShort; // null if next not known
    private final int maxLen; // only return strings <=

    public ShortStrings(Iterator<String> strings,
            int maxLen) {
        this.strings = strings;
        this.maxLen = maxLen;
        nextShort = null;
    }

    @Override
    public boolean hasNext() {
        if (nextShort != null) // found it already
        {
            return true;
        }
        while (strings.hasNext()) {
            nextShort = strings.next();
            if (nextShort.length() <= maxLen) {
                return true;
            }
        }
        nextShort = null; // didn't find one
        return false;
    }

    @Override
    public String next() {
        if (nextShort == null && !hasNext()) {
            throw new NoSuchElementException();
        }
        String n = nextShort; // remember nextShort
        nextShort = null; // consume nextShort
        return n; // return nextShort
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

public class IteratorUsage {

    public static void removeLongStrings(Collection<? extends String> coll, int maxLen) {
        Iterator<? extends String> it = coll.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.length() > maxLen) {
                it.remove();
            }
        }
        System.out.println(coll.toString());
    }

    public static void main(String args[]) {
        Set<String> words = new TreeSet<String>(Arrays.asList("go", "went", "gone", "go"));
        IteratorUsage.removeLongStrings(words, 2);
    }
}
