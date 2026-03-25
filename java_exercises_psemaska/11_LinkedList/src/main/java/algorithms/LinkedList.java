package algorithms;

import java.util.ArrayList;

public class LinkedList<E> implements List<E> {

    private int size;

    private final Element<E> headAndTail;

    private ArrayList<E> values = new ArrayList<>();

    public LinkedList() {
        size = 0;
        headAndTail = new Element<>(null);
        clear();
    }

    @Override
    public void insert(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> element = new Element<>(value);
        element.attachBefore(getElement(index));
        values.add(element.getValue());
        ++size;
    }

    private Element<E> getElement(int index) {
        Element<E> element = headAndTail.getNext();

        for (int i = 0; i < index; ++i) {
            element = element.getNext();
        }

        return element;
    }

    @Override
    public void add(E value) {
        Element<E> lastElement = getElement(size - 1);
        Element<E> element = new Element<>(value);
        lastElement.setNext(element);
        element.setPrev(lastElement);
        element.setNext(headAndTail);
        values.add(element.getValue());
        ++size;
    }

    @Override
    public E delete(int index) {
        checkOutBounds(index);

        Element<E> element = getElement(index);
        element.detach();
        values.remove(index);
        --size;

        return element.getValue();
    }

    @Override
    public boolean delete(E value) {

        for(int i = 0; i < size; i++) {
            Element<E> element = getElement(i);
            if(element.getValue().equals(value)) {
                element.getNext().setPrev(element.getPrev());
                element.getPrev().setNext(element.getNext());
                values.remove(i);
                --size;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        headAndTail.setNext(headAndTail);
        headAndTail.setPrev(headAndTail);
        values.clear();
        size = 0;
    }

    @Override
    public E set(int index, E value) {
        checkOutBounds(index);
        Element<E> element = getElement(index);
        E oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    @Override
    public E get(int index) {
        checkOutBounds(index);
        Element<E> element = getElement(index);
        return element.getValue();
    }

    @Override
    public int indexOf(E value) {
        Element<E> element = headAndTail.getNext();
        for(int i = 0; i < size; i++) {
            if(element.getValue().equals(value)) {
                return i;
            }
            element = element.getNext();
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        Element<E> element = headAndTail.getNext();
        for(int i = 0; i < size; i++) {
            if(element.getValue().equals(value)) {
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(headAndTail.getNext() == headAndTail){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private void checkOutBounds(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= size;
    }

    private static final class Element<E> {
        private E value;

        private Element<E> next;

        private Element<E> prev;

        public Element(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element<E> getNext() {
            return next;
        }

        public void setNext(Element<E> next) {
            this.next = next;
        }

        public Element<E> getPrev() {
            return prev;
        }

        public void setPrev(Element<E> prev) {
            this.prev = prev;
        }

        public void attachBefore(Element<E> next) {
            setNext(next);
            setPrev(next.getPrev());

            next.setPrev(this);
            getPrev().setNext(this);
        }

        public void detach() {
            getPrev().setNext(getNext());
            getNext().setPrev(getPrev());
        }
    }

    private class MyIterator implements Iterator<E> {

        private int index = 0;

        @Override
        public void first() {
            values.get(0);
        }

        @Override
        public void last() {
            values.get(size);
        }

        @Override
        public boolean isDone() {
            return index < values.size() && values.get(index) != null;
        }

        @Override
        public void next() {
            values.get(index+1);
        }

        @Override
        public void previous() {
            values.get(index-1);
        }

        @Override
        public E current() {
            return values.get(index);
        }
    }

}
