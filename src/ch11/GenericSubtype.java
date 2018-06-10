package ch11;

import java.util.*;

class Cell<E> {

    private Cell<E> next;
    private E element;

    public Cell(E element) {
        this.element = element;
    }

    public Cell(E element, Cell<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Cell<E> getNext() {
        return next;
    }

    public void setNext(Cell<E> next) {
        this.next = next;
    }
}

class SingleLinkQueue<E> {

    protected Cell<E> head;
    protected Cell<E> tail;

    public void add(E item) {
        Cell<E> cell = new Cell<E>(item);
        if (tail == null) {
            head = tail = cell;
        } else {
            tail.setNext(cell);
            tail = cell;
        }
    }

    public E remove() {
        if (head == null) {
            return null;
        }
        Cell<E> cell = head;
        head = head.getNext();
        if (head == null) {
            tail = null; // empty queue
        }
        return cell.getElement();
    }
}

public class GenericSubtype {

    // List<Integer> is not a subclass of List<Number>
    static double sum1(List<Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // valid usage
    // match a list of Number or its subclasses
    static double sum2(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    static void testSum() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(4);
        l.add(9);
        // INVALID: won't compile
        //double sum = sum1(l);
        double sum = sum2(l);
        System.out.println(sum);
    }

    
    // also, List<? super Integer>
    // match a list of Integer or its superclasses
    
    // List<?> is equivalent to List<? extends Object>
    
    // interface SortedCollection<E extends Comparable<? super E>> {...}
    
    static void testUnknownType() {
         
        //SingleLinkQueue<?> strings = new SingleLinkQueue<String>();
        // INVALID: won't compile
        //strings.add("Hello");
        
        SingleLinkQueue<? extends Number> numbers = new SingleLinkQueue<Number>();
        // INVALID: won't compile
        //numbers.add(Integer.valueOf(25));
        
        // CORRECT
        SingleLinkQueue<? super String> strings = new SingleLinkQueue<String>();
        strings.add("Hello");
    }

    public static void main(String args[]) {
        GenericSubtype.testSum();
    }
}
