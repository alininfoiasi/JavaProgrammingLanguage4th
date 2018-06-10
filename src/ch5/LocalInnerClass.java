package ch5;

import java.util.*;

public class LocalInnerClass {

    //private int pos;
    public static Iterator<Object> walkThroughV1(final Object[] objs) {
        class Iter implements Iterator<Object> {

            // hiding fields here makes impossible the access to them
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return (pos < objs.length);
            }

            @Override
            public Object next() throws NoSuchElementException {
                if (pos >= objs.length) {
                    throw new NoSuchElementException();
                }
                return objs[pos++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
        return new Iter();
    }

    // variant using anonymous class
    public static Iterator<Object> walkThroughV2(final Object[] objs) {
        return new Iterator<Object>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return (pos < objs.length);
            }

            @Override
            public Object next() throws NoSuchElementException {
                if (pos >= objs.length) {
                    throw new NoSuchElementException();
                }
                return objs[pos++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String args[]) {
    }
}
