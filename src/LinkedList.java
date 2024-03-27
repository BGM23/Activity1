import java.util.NoSuchElementException;

interface LinkedList<E> {
    void addFirst(E element);
    void addLast(E element);
    boolean contains(E element);
    E peekFirst();
    E peekLast();
    E pollFirst();
    E pollLast();
    int size();
    void clear();
}
