import java.util.NoSuchElementException;

class SinglyLinkedList<E> implements LinkedList<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean contains(E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(element))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E data = tail.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
        return data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
